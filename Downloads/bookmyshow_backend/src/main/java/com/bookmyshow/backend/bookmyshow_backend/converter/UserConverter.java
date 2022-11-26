package com.bookmyshow.backend.bookmyshow_backend.converter;

import com.bookmyshow.backend.bookmyshow_backend.DTO.TicketDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.UserDTO;
import com.bookmyshow.backend.bookmyshow_backend.models.TicketEntity;
import com.bookmyshow.backend.bookmyshow_backend.models.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class UserConverter {
    public static UserEntity convertDtoToEntity(UserDTO userDto){
        return UserEntity.builder().name(userDto.getName()).number(userDto.getNumber()).build();
    }

    public static UserDTO convertEntityToDto(Optional<UserEntity> userEntity) {
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        if (userEntity.isPresent()) {
            for(TicketEntity ticket : userEntity.get().getTickets()) {
                ticketDTOList.add(TicketConverter.convertEntityToDtoByEntity(ticket));
            }
        }
        return UserDTO.builder().user_id(userEntity.get().getUsr_id()).name(userEntity.get().getName()).number(userEntity.get().getNumber()).listOfTicket(ticketDTOList).build();
    }
    public static  UserDTO convertEntityToDtoByEntity(UserEntity user) {
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for(TicketEntity ticket : user.getTickets()) {
            ticketDTOList.add(TicketConverter.convertEntityToDtoByEntity(ticket));
        }
        return UserDTO.builder().user_id(user.getUsr_id()).name(user.getName()).number(user.getNumber()).listOfTicket(ticketDTOList).build();
    }
}
