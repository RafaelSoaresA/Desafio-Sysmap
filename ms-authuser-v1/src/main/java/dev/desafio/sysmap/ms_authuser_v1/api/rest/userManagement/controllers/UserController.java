package dev.desafio.sysmap.ms_authuser_v1.api.rest.userManagement.controllers;

import dev.desafio.sysmap.ms_authuser_v1.api.rest.userManagement.UserDetailsImpl;
import dev.desafio.sysmap.ms_authuser_v1.core.application.service.UserService;
import dev.desafio.sysmap.ms_authuser_v1.core.domain.entity.UserModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

  /*  @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity<Page<UserModel>> getAllUsers(@PageableDefault(page = 0, size = 10, sort = "userId",
                                                               direction = Sort.Direction.ASC) Pageable pageable,
                                                       Authentication authentication) {
        UserDetails userDetails = (UserDetailsImpl) authentication.getPrincipal();
        log.info("Authentication {} ", userDetails.getUsername());
        Page<UserModel> userModelPage = userService.findAll(pageable);
        if (!userModelPage.isEmpty()) {
            for (UserModel user : userModelPage.toList()) {
                user.add(linkTo(methodOn(UserController.class).getOneUser(user.getUserId())).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(userModelPage);
    }*/

}
