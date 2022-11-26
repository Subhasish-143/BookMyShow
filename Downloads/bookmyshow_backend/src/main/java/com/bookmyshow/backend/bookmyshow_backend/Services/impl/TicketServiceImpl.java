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
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
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
        // UserEntity from user_id
        UserEntity userEntity = userRepository.findById(bookTicketRequest.getUsr_id()).get();

        // ShowEntity from show_id
        ShowEntity showEntity = showRepository.findById(bookTicketRequest.getShowId()).get();

        // requested seats to be booked
        Set<String> requestedSeats = bookTicketRequest.getRequestedSeats();

        // finding the ShowSeats which are available for the Show
        // getting it from ShowEntity
        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getListOfShowSeats();

        // the seats that can be booked
        // checking the ShowSeats that whether they are available for booking or not
        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList.stream()
                .filter(showSeat -> showSeat.getSeatType().equals(bookTicketRequest.getSeatType()) && !showSeat.isBooked() && requestedSeats.contains(showSeat.getSeatNumber()))
                .collect(Collectors.toList());

        // if all requestedSeats are not available
        if (bookedSeats.size() != requestedSeats.size()) {
            // all seats are not available
            throw new Error("All seats are not available");
        }

        // building ticketEntity to convert it to ticketDTO
        TicketEntity ticketEntity = TicketEntity.builder().user(userEntity).show(showEntity).build();

        // total amount needed to book all tickets
        double amount = 0;
        for(ShowSeatsEntity showSeat : bookedSeats) {
            // booking the seats
            showSeat.setBooked(true);
            // booked time
            showSeat.setBookedAt(new Date());
            // setting the ticketEntity through which the showSeat was booked
            showSeat.setTicket(ticketEntity);
            // price of showSeat is added to total amount
            amount += showSeat.getRate();
        }

        // all the bookedSeats stored in a String format
        ticketEntity.setAlloted_Seats(String.valueOf(bookedSeats));
        // setting the total amount for ticketEntity
        ticketEntity.setAmount(amount);

        // list of ticketEntity booked by the user
        userEntity.getTickets().add(ticketEntity);

        // list of ticketEntity booked for the show
        showEntity.getListOfTickets().add(ticketEntity);


        ticketRepository.save(ticketEntity);

        return TicketConverter.convertEntityToDto(Optional.of(ticketEntity));
    }
}
