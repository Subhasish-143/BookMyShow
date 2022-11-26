package com.bookmyshow.backend.bookmyshow_backend.DTO;

import com.bookmyshow.backend.bookmyshow_backend.Enum.SeatType;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterDTO {
    int theat_id;
    String name;
    String city;
    String address;

    // ShowEntity
    List<ShowDTO> listOfShows;
}
