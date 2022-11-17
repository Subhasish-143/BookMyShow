package com.bookmyshow.backend.bookmyshow_backend.converter;

import com.bookmyshow.backend.bookmyshow_backend.DTO.TicketDTO;
import com.bookmyshow.backend.bookmyshow_backend.models.TicketEntity;

import java.util.Optional;

public class TicketConverter {
    public static TicketDTO convertEntityToDto(Optional<TicketEntity> ticketEntity) {
        return TicketDTO.builder().tickt_id(ticketEntity.get().getTicket_id()).alloted_seats(ticketEntity.get().getAlloted_Seats()).amount(ticketEntity.get().getAmount()).build();
    }
}
