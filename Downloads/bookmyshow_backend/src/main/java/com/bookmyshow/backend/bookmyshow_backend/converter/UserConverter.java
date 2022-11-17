package com.bookmyshow.backend.bookmyshow_backend.converter;

import com.bookmyshow.backend.bookmyshow_backend.DTO.UserDTO;
import com.bookmyshow.backend.bookmyshow_backend.models.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class UserConverter {
    public static UserEntity convertDtoToEntity(UserDTO userDto){
        return UserEntity.builder().name(userDto.getName()).number(userDto.getNumber()).build();
    }

    public static UserDTO convertEntityToDto(Optional<UserEntity> userEntity) {
        return UserDTO.builder().user_id(userEntity.get().getUsr_id()).name(userEntity.get().getName()).number(userEntity.get().getNumber()).build();
    }
}
