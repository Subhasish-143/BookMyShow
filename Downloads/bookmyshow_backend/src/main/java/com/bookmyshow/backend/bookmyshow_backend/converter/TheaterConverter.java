package com.bookmyshow.backend.bookmyshow_backend.converter;

import com.bookmyshow.backend.bookmyshow_backend.DTO.TheaterDTO;
import com.bookmyshow.backend.bookmyshow_backend.models.TheaterEntity;

import java.util.Optional;

public class TheaterConverter {
    public static TheaterEntity convertDtoToEntity(TheaterDTO theat) {
        return TheaterEntity.builder().theat_id(theat.getTheat_id()).name(theat.getName()).city(theat.getCity()).address(theat.getAddress()).build();
    }

    public static TheaterDTO convertEntityToDto(Optional<TheaterEntity> theater) {
        return TheaterDTO.builder().theat_id(theater.get().getTheat_id()).name(theater.get().getName()).city(theater.get().getCity()).address(theater.get().getAddress()).build();
    }
}
