package com.bookmyshow.backend.bookmyshow_backend.DTO;

import com.bookmyshow.backend.bookmyshow_backend.Enum.SeatType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookTicketRequestDTO {
    Set<String> requestedSeats;
    int usr_id;
    int showId;
    SeatType seatType;
}
