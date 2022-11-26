package com.bookmyshow.backend.bookmyshow_backend.Services;

import com.bookmyshow.backend.bookmyshow_backend.DTO.ShowDTO;

public interface ShowService {
    void addShow(ShowDTO showDTO,int mov_id,int tht_id);
    ShowDTO getShow(int id);
}
