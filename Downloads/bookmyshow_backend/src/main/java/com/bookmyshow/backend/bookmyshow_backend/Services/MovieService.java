package com.bookmyshow.backend.bookmyshow_backend.Services;

import com.bookmyshow.backend.bookmyshow_backend.DTO.MovieDTO;
import com.bookmyshow.backend.bookmyshow_backend.models.MovieEntity;

public interface MovieService {
    // add movie
    void addMovie(MovieDTO movie);

    // get movie
    MovieDTO getMovie(int id);
}
