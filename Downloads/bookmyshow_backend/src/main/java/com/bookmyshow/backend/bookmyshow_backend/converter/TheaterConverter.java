package com.bookmyshow.backend.bookmyshow_backend.converter;

import com.bookmyshow.backend.bookmyshow_backend.DTO.ShowDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.TheaterDTO;
import com.bookmyshow.backend.bookmyshow_backend.models.ShowEntity;
import com.bookmyshow.backend.bookmyshow_backend.models.TheaterEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TheaterConverter {
    public static TheaterEntity convertDtoToEntity(TheaterDTO theat) {
        return TheaterEntity.builder().theat_id(theat.getTheat_id()).name(theat.getName()).city(theat.getCity()).address(theat.getAddress()).build();
    }

    public static TheaterDTO convertEntityToDto(Optional<TheaterEntity> theater) {
        List<ShowDTO> showDTOList = new ArrayList<>();
        if (theater.isPresent()) {
            for(ShowEntity sEntity : theater.get().getListOfShows()) {
                showDTOList.add(ShowConverter.convertEntityToDtoByEntity(sEntity));
            }
        }
        return TheaterDTO.builder().theat_id(theater.get().getTheat_id()).name(theater.get().getName()).city(theater.get().getCity()).address(theater.get().getAddress()).listOfShows(showDTOList).build();
    }

    public static TheaterDTO convertEntityToDtoByEntity(TheaterEntity theater) {
        List<ShowDTO> showDTOList = new ArrayList<>();
        for(ShowEntity sEntity : theater.getListOfShows()) {
            showDTOList.add(ShowConverter.convertEntityToDtoByEntity(sEntity));
        }
        return TheaterDTO.builder().theat_id(theater.getTheat_id()).name(theater.getName()).city(theater.getCity()).address(theater.getAddress()).listOfShows(showDTOList).build();
    }
}
