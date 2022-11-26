package com.bookmyshow.backend.bookmyshow_backend.Controller;

import com.bookmyshow.backend.bookmyshow_backend.DTO.BookTicketRequestDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.TicketDTO;
import com.bookmyshow.backend.bookmyshow_backend.Services.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    TicketServiceImpl ticketService;

    @GetMapping("{id}")
    public ResponseEntity<TicketDTO> getTicket(@PathVariable int id) {
        return new ResponseEntity<>(ticketService.getTicket(id), HttpStatus.FOUND);
    }

    @PostMapping("add")
    public ResponseEntity<TicketDTO> bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) {
        TicketDTO ticketDTO = ticketService.bookTicket(bookTicketRequestDTO);
        return new ResponseEntity<>(ticketDTO,HttpStatus.CREATED);
    }
}
