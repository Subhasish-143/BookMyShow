package com.bookmyshow.backend.bookmyshow_backend.Services;

import com.bookmyshow.backend.bookmyshow_backend.DTO.BookTicketRequestDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.TicketDTO;

public interface TicketService {
    TicketDTO getTicket(int id);
    TicketDTO bookTicket(BookTicketRequestDTO bookTicketRequest);
}
