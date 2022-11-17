package com.bookmyshow.backend.bookmyshow_backend.Services.impl;

import com.bookmyshow.backend.bookmyshow_backend.DTO.MovieDTO;
import com.bookmyshow.backend.bookmyshow_backend.Repository.MovieRepository;
import com.bookmyshow.backend.bookmyshow_backend.Services.MovieService;
import com.bookmyshow.backend.bookmyshow_backend.converter.MovieConverter;
import com.bookmyshow.backend.bookmyshow_backend.models.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public void addMovie(MovieDTO movie) {
        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movie);

        movieRepository.save(movieEntity);
    }

    @Override
    public MovieDTO getMovie(int id) {
        return MovieConverter.convertEntityToDto(id);
    }
}
