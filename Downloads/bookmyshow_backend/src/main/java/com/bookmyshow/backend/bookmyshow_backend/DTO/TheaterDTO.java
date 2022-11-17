package com.bookmyshow.backend.bookmyshow_backend.DTO;

import com.bookmyshow.backend.bookmyshow_backend.Enum.SeatType;
import lombok.*;

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

    // TheaterSeat


    // ShowEntity
    ShowDTO showDTO;
}
