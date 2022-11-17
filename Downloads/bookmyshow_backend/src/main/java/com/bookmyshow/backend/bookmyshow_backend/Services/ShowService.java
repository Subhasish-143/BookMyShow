package com.bookmyshow.backend.bookmyshow_backend.Services;

import com.bookmyshow.backend.bookmyshow_backend.DTO.ShowDTO;

public interface ShowService {
    void addShow(ShowDTO showDTO);
    ShowDTO getShow(int id);
}
