package com.bookmyshow.backend.bookmyshow_backend.Services;

import com.bookmyshow.backend.bookmyshow_backend.DTO.TheaterDTO;
import com.bookmyshow.backend.bookmyshow_backend.models.TheaterEntity;

public interface TheaterService {
    // add theater
    void addTheater(TheaterDTO theaterDTO);

    // get theater
    TheaterDTO getTheater(int id);
}