package dev.desafio.sysmap.ms_authuser_v1.core.application.service;

import dev.desafio.sysmap.ms_authuser_v1.api.rest.userManagement.repositories.UserRepository;
import dev.desafio.sysmap.ms_authuser_v1.core.domain.entity.UserModel;
import dev.desafio.sysmap.ms_authuser_v1.core.infraestructure.event.kafka.UserEventProducer;
import dev.desafio.sysmap.ms_authuser_v1.core.port.in.dto.enums.ActionType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

//    @Autowired
//    CourseClient courseClient;

    @Autowired
    UserEventProducer userEventPublisher;

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    @Override
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }

    @Override
    public UserModel save(UserModel userModel) {
        userRepository.save(userModel);
        return userModel;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Page<UserModel> findAll(Specification<UserModel> spec, Pageable pageable) {
        return userRepository.findAll(spec, pageable);
    }
    @Transactional
    @Override
    public UserModel saveUser(UserModel userModel){
        save(userModel);
        userEventPublisher.publishUserEvent(userModel.convertToUserEventDto(), ActionType.CREATE);
        return userModel;
    }
    @Transactional
    @Override
    public void deleteUser(UserModel userModel) {
        delete(userModel);
        userEventPublisher.publishUserEvent(userModel.convertToUserEventDto(), ActionType.DELETE);
    }
    @Transactional
    @Override
    public UserModel updateUser(UserModel userModel) {
        save(userModel);
        userEventPublisher.publishUserEvent(userModel.convertToUserEventDto(), ActionType.UPDATE);
        return userModel;
    }

    @Override
    public UserModel updatePassword(UserModel userModel) {
        return save(userModel);
    }
}
