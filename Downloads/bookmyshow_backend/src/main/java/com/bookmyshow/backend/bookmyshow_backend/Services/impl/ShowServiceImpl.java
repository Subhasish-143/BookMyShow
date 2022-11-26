package com.bookmyshow.backend.bookmyshow_backend.Services.impl;

import com.bookmyshow.backend.bookmyshow_backend.Enum.SeatType;
import com.bookmyshow.backend.bookmyshow_backend.Repository.ShowSeatsRepository;
import com.bookmyshow.backend.bookmyshow_backend.models.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookmyshow.backend.bookmyshow_backend.DTO.MovieDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.ShowDTO;
import com.bookmyshow.backend.bookmyshow_backend.Repository.MovieRepository;
import com.bookmyshow.backend.bookmyshow_backend.Repository.ShowRepository;
import com.bookmyshow.backend.bookmyshow_backend.Repository.TheaterRepository;
import com.bookmyshow.backend.bookmyshow_backend.Services.ShowService;
import com.bookmyshow.backend.bookmyshow_backend.converter.ShowConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Override
    public void addShow(ShowDTO showDTO,int mov_id,int tht_id) {
        // partial ShowEntity
        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showDTO);

        // Movie Entity
        MovieEntity movieEntity = movieRepository.findById(mov_id).get();
        // Theater Entity
        TheaterEntity theaterEntity = theaterRepository.findById(tht_id).get();

        // setting up the movie and theater in show entity
        showEntity.setMovie(movieEntity);
        showEntity.setTheater(theaterEntity);

        // ShowSeats are dependent of show
        // So they will be got created at the time of showEntity creation
        // for all the seats of the theater
        createShowSeats(showEntity,theaterEntity.getListOfTheaterSeat());

        // ShowEntity to be added on MovieEntity
        movieEntity.getShows().add(showEntity);

        // ShowEntity to be added on Theater Entity
        theaterEntity.getListOfShows().add(showEntity);

        // saving showEntity in ShowRepository
        showRepository.save(showEntity);
    }

    void createShowSeats(ShowEntity showEntity, List<TheaterSeatEntity>theaterSeats) {
        List<ShowSeatsEntity> Seats = new ArrayList<>();

        for(TheaterSeatEntity thSeat : theaterSeats) {
            Seats.add(getShowSeats(thSeat.getSeatNumber(),thSeat.getSeatType(),thSeat.getRate(),showEntity));
        }

        // all info of ShowSeats is saved in ShowSeatsRepository
        showSeatsRepository.saveAll(Seats);

        // saving list of seats to the showEntity
        showEntity.setListOfShowSeats(Seats);
    }

    // filling all the required filled as well as the ShowEntity part also
    public static ShowSeatsEntity getShowSeats(String seatName, SeatType seatType, int rate, ShowEntity showEntity) {
        return ShowSeatsEntity.builder().seatNumber(seatName).seatType(seatType).rate(rate).show(showEntity).build();
    }
    @Override
    public ShowDTO getShow(int id) {
        Optional<ShowEntity> showEntity = showRepository.findById(id);
        return ShowConverter.convertEntityToDto(showEntity);
    }
    
}
