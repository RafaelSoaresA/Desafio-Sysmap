package dev.desafio.sysmap.ms_authuser_v1.core.infraestructure.event.kafka;

import dev.desafio.sysmap.ms_authuser_v1.core.port.in.dto.UserEventDto;
import dev.desafio.sysmap.ms_authuser_v1.core.port.in.dto.enums.ActionType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserEventProducer {

    @Value(value = "${TOPIC-USER-INFO:dev.desafio.sysmap-tp-user}")
    private String exchangeUserEvent;

    public void publishUserEvent(UserEventDto userEventDto, ActionType actionType){
        userEventDto.setActionType(actionType.toString());
    }
}
