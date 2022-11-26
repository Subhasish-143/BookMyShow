package com.bookmyshow.backend.bookmyshow_backend.Services.impl;

import com.bookmyshow.backend.bookmyshow_backend.DTO.MovieDTO;
import com.bookmyshow.backend.bookmyshow_backend.Repository.MovieRepository;
import com.bookmyshow.backend.bookmyshow_backend.Services.MovieService;
import com.bookmyshow.backend.bookmyshow_backend.converter.MovieConverter;
import com.bookmyshow.backend.bookmyshow_backend.models.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
        Optional<MovieEntity> movie = movieRepository.findById(id);
        return MovieConverter.convertEntityToDto(movie);
    }

    @Override
    public MovieDTO getMovie(String name) {
        return MovieConverter.convertEntityToDtoByEntity(movieRepository.findByName(name));
    }
}
