package dev.desafio.sysmap.ms_authuser_v1.core.port.in;

import dev.desafio.sysmap.ms_authuser_v1.core.port.in.dto.UserDto;

public interface UserPortIn {
    UserDto Users(UserDto userDto);
}
