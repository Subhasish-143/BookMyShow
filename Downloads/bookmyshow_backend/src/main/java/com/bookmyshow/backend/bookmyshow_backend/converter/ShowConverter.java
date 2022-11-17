package com.bookmyshow.backend.bookmyshow_backend.converter;

import com.bookmyshow.backend.bookmyshow_backend.DTO.ShowDTO;
import com.bookmyshow.backend.bookmyshow_backend.models.ShowEntity;

import java.util.Optional;

public class ShowConverter {
    public static ShowEntity convertDtoToEntity(ShowDTO showDTO) {
        return ShowEntity.builder().showDate(showDTO.getShowDate()).showtime(showDTO.getShowTime()).build();
    }

    public static ShowDTO convertEntityToDto(Optional<ShowEntity> showEntity) {
        return ShowDTO.builder().showDate(showEntity.get().getShowDate()).showTime(showEntity.get().getShowtime()).build();
    }
}
