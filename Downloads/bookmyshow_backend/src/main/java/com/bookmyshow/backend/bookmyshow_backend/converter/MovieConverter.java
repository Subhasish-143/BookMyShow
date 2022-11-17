package com.bookmyshow.backend.bookmyshow_backend.converter;

import com.bookmyshow.backend.bookmyshow_backend.DTO.MovieDTO;
import com.bookmyshow.backend.bookmyshow_backend.Repository.MovieRepository;
import com.bookmyshow.backend.bookmyshow_backend.models.MovieEntity;
import com.bookmyshow.backend.bookmyshow_backend.models.UserEntity;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@UtilityClass
public class MovieConverter {
    @Autowired
    MovieRepository movieRepository;

    public MovieEntity convertDtoToEntity(MovieDTO movie) {
        return MovieEntity.builder().name(movie.getName()).released_date(movie.getRelease_date()).build();
    }
    public MovieDTO convertEntityToDto(int id) {
        Optional<MovieEntity> movie = movieRepository.findById(id);

        return MovieDTO.builder().mov_id(movie.get().getMov_id()).name(movie.get().getName()).release_date(movie.get().getReleased_date()).build();
    }
}
