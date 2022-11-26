package com.bookmyshow.backend.bookmyshow_backend.converter;

import com.bookmyshow.backend.bookmyshow_backend.DTO.MovieDTO;
import com.bookmyshow.backend.bookmyshow_backend.DTO.ShowDTO;
import com.bookmyshow.backend.bookmyshow_backend.Repository.MovieRepository;
import com.bookmyshow.backend.bookmyshow_backend.models.MovieEntity;
import com.bookmyshow.backend.bookmyshow_backend.models.ShowEntity;
import com.bookmyshow.backend.bookmyshow_backend.models.UserEntity;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class MovieConverter {
    @Autowired
    MovieRepository movieRepository;

    public MovieEntity convertDtoToEntity(MovieDTO movie) {
        return MovieEntity.builder().name(movie.getName()).released_date(movie.getRelease_date()).build();
    }
    public MovieDTO convertEntityToDto(Optional<MovieEntity> movie) {
        List<ShowDTO> showDTOList = new ArrayList<>();
        for(ShowEntity sEntity : movie.get().getShows()) {
            showDTOList.add(ShowConverter.convertEntityToDtoByEntity(sEntity));
        }
        return MovieDTO.builder().mov_id(movie.get().getMov_id()).name(movie.get().getName()).release_date(movie.get().getReleased_date()).showDTOList(showDTOList).build();
    }
    public MovieDTO convertEntityToDtoByEntity(MovieEntity movie) {
        List<ShowDTO> showDTOList = new ArrayList<>();
        for(ShowEntity sEntity : movie.getShows()) {
            showDTOList.add(ShowConverter.convertEntityToDtoByEntity(sEntity));
        }
        return MovieDTO.builder().mov_id(movie.getMov_id()).name(movie.getName()).release_date(movie.getReleased_date()).showDTOList(showDTOList).build();
    }
}
