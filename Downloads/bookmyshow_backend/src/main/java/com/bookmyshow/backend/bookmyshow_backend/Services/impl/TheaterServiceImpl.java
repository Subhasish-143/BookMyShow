package com.bookmyshow.backend.bookmyshow_backend.Services.impl;


import com.bookmyshow.backend.bookmyshow_backend.DTO.TheaterDTO;
import com.bookmyshow.backend.bookmyshow_backend.Enum.SeatType;
import com.bookmyshow.backend.bookmyshow_backend.Repository.TheaterRepository;
import com.bookmyshow.backend.bookmyshow_backend.Repository.TheaterSeatsRepository;
import com.bookmyshow.backend.bookmyshow_backend.Services.TheaterService;
import com.bookmyshow.backend.bookmyshow_backend.converter.TheaterConverter;
import com.bookmyshow.backend.bookmyshow_backend.models.TheaterEntity;
import com.bookmyshow.backend.bookmyshow_backend.models.TheaterSeatEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TheaterServiceImpl implements TheaterService {
    @Autowired
    TheaterRepository theaterRepo;

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    @Override
    public void addTheater(TheaterDTO theaterDTO) {
        TheaterEntity theater = TheaterConverter.convertDtoToEntity(theaterDTO);

        // create TheaterSeats
        List<TheaterSeatEntity> seats = createTheaterSeats();

        // marking seats with its theater id
        for(TheaterSeatEntity theaterSeatEntity : seats) {
            theaterSeatEntity.setTheater(theater);
        }

        theater.setListOfTheaterSeat(seats);

        // add TheaterEntity into the TheaterRepository Database
        theaterRepo.save(theater);

    }
    List<TheaterSeatEntity> createTheaterSeats() {
        List<TheaterSeatEntity> Seats = new ArrayList<>();

        Seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        Seats.add(getTheaterSeat("1B",100,SeatType.CLASSIC));
        Seats.add(getTheaterSeat("1C",100,SeatType.CLASSIC));
        Seats.add(getTheaterSeat("1D",100,SeatType.CLASSIC));
        Seats.add(getTheaterSeat("1E",100,SeatType.CLASSIC));

        Seats.add(getTheaterSeat("2A",300,SeatType.PREMIUM));
        Seats.add(getTheaterSeat("2B",300,SeatType.PREMIUM));
        Seats.add(getTheaterSeat("2C",300,SeatType.PREMIUM));
        Seats.add(getTheaterSeat("2D",300,SeatType.PREMIUM));
        Seats.add(getTheaterSeat("2E",300,SeatType.PREMIUM));

        theaterSeatsRepository.saveAll(Seats);

        return Seats;
    }
    TheaterSeatEntity getTheaterSeat(String seatName, int rate, SeatType seatType) {
        return TheaterSeatEntity.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheaterDTO getTheater(int id) {
        Optional<TheaterEntity> theater = theaterRepo.findById(id);
        return TheaterConverter.convertEntityToDto(theater);
    }


}
