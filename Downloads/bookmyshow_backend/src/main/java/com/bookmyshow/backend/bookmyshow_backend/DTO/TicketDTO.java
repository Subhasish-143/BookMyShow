package com.bookmyshow.backend.bookmyshow_backend.DTO;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {

    // only used for carrying the backend info to the front

    long tickt_id;
    String alloted_seats;
    double amount;

    ShowDTO showDTO;

    UserDTO userDTO;
}
