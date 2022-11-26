package com.bookmyshow.backend.bookmyshow_backend.converter;

import com.bookmyshow.backend.bookmyshow_backend.DTO.MovieDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.ShowDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.TheaterDTO;
import com.bookmyshow.backend.bookmyshow_backend.models.ShowEntity;

import java.util.Optional;

public class ShowConverter {
    public static ShowEntity convertDtoToEntity(ShowDTO showDTO) {
        return ShowEntity.builder().showDate(showDTO.getShowDate()).showtime(showDTO.getShowTime()).build();
    }

    public static ShowDTO convertEntityToDto(Optional<ShowEntity> showEntity) {
        MovieDTO movieDTO = MovieConverter.convertEntityToDtoByEntity(showEntity.get().getMovie());
        TheaterDTO theaterDTO = TheaterConverter.convertEntityToDtoByEntity(showEntity.get().getTheater());
        return ShowDTO.builder().showDate(showEntity.get().getShowDate()).showTime(showEntity.get().getShowtime()).movieDTO(movieDTO).theaterDTO(theaterDTO).build();
    }

    public static ShowDTO convertEntityToDtoByEntity(ShowEntity show) {
        MovieDTO movieDTO = MovieConverter.convertEntityToDtoByEntity(show.getMovie());
        TheaterDTO theaterDTO = TheaterConverter.convertEntityToDtoByEntity(show.getTheater());
        return ShowDTO.builder().id(show.getShow_id()).showDate(show.getShowDate()).showTime(show.getShowtime()).movieDTO(movieDTO).theaterDTO(theaterDTO).build();
    }
}
