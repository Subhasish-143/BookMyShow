package com.bookmyshow.backend.bookmyshow_backend.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowDTO {
    long id;
    @NotNull
    LocalDate showDate;
    @NotNull
    LocalTime showTime;

    MovieDTO movieDTO;

    TheaterDTO theaterDTO;
}
