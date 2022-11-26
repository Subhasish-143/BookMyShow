package com.bookmyshow.backend.bookmyshow_backend.converter;

import com.bookmyshow.backend.bookmyshow_backend.DTO.ShowDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.TicketDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.UserDTO;
import com.bookmyshow.backend.bookmyshow_backend.models.ShowEntity;
import com.bookmyshow.backend.bookmyshow_backend.models.TicketEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketConverter {
    public static TicketDTO convertEntityToDto(Optional<TicketEntity> ticketEntity) {
        ShowDTO showDTO = ShowConverter.convertEntityToDtoByEntity(ticketEntity.get().getShow());
        UserDTO userDTO = UserConverter.convertEntityToDtoByEntity(ticketEntity.get().getUser());
        return TicketDTO.builder().tickt_id(ticketEntity.get().getTicket_id()).alloted_seats(ticketEntity.get().getAlloted_Seats()).amount(ticketEntity.get().getAmount()).showDTO(showDTO).userDTO(userDTO).build();
    }
    public static TicketDTO convertEntityToDtoByEntity(TicketEntity ticketEntity) {
        ShowDTO showDTO = ShowConverter.convertEntityToDtoByEntity(ticketEntity.getShow());
        UserDTO userDTO = UserConverter.convertEntityToDtoByEntity(ticketEntity.getUser());
        return TicketDTO.builder().tickt_id(ticketEntity.getTicket_id()).alloted_seats(ticketEntity.getAlloted_Seats()).amount(ticketEntity.getAmount()).showDTO(showDTO).userDTO(userDTO).build();
    }
}
