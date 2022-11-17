package com.bookmyshow.backend.bookmyshow_backend.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowDTO {
    long id;
    LocalDate showDate;
    LocalTime showTime;

    MovieDTO movieDTO;
    TheaterDTO theaterDTO;
}
