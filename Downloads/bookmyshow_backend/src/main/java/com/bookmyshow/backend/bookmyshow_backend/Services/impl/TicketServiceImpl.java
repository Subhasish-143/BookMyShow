package com.bookmyshow.backend.bookmyshow_backend.Services.impl;

import com.bookmyshow.backend.bookmyshow_backend.DTO.BookTicketRequestDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.TicketDTO;
import com.bookmyshow.backend.bookmyshow_backend.Repository.ShowRepository;
import com.bookmyshow.backend.bookmyshow_backend.Repository.ShowSeatsRepository;
import com.bookmyshow.backend.bookmyshow_backend.Repository.TicketRepository;
import com.bookmyshow.backend.bookmyshow_backend.Repository.UserRepository;
import com.bookmyshow.backend.bookmyshow_backend.Services.TicketService;
import com.bookmyshow.backend.bookmyshow_backend.converter.TicketConverter;
import com.bookmyshow.backend.bookmyshow_backend.models.ShowEntity;
import com.bookmyshow.backend.bookmyshow_backend.models.ShowSeatsEntity;
import com.bookmyshow.backend.bookmyshow_backend.models.TicketEntity;
import com.bookmyshow.backend.bookmyshow_backend.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Override
    public TicketDTO getTicket(int id) {
        Optional<TicketEntity> ticketEntity = ticketRepository.findById(id);

        return TicketConverter.convertEntityToDto(ticketEntity);
    }

    @Override
    public TicketDTO bookTicket(BookTicketRequestDTO bookTicketRequest) {
        UserEntity userEntity = userRepository.findById(bookTicketRequest.getUsr_id()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequest.getShowId()).get();

        Set<String> requestedSeats = bookTicketRequest.getRequestedSeats();

        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getListOfShowSeats();

        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList.stream()
                .filter(seat -> seat.getSeatType().equals(bookTicketRequest.getSeatType()) && !seat.isBooked() && requestedSeats.contains(seat.getSeatNumber()))
                .collect(Collectors.toList());


        if (bookedSeats.size() != requestedSeats.size()) {
            // all seats are not available
            throw new Error("All seats are not available");
        }

        TicketEntity ticketEntity = TicketEntity.builder().user(userEntity).show(showEntity).build();


        double amount = 0;
        for(ShowSeatsEntity showSeatsEntity : bookedSeats) {
            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());
            showSeatsEntity.setTicket(ticketEntity);

            amount += showSeatsEntity.getRate();
        }

        ticketEntity.setAlloted_Seats(String.valueOf(bookedSeats));
        ticketEntity.setAmount(amount);




        ticketRepository.save(ticketEntity);

        return TicketConverter.convertEntityToDto(Optional.of(ticketEntity));
    }
}
