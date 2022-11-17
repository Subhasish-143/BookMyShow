package com.bookmyshow.backend.bookmyshow_backend.DTO;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {
    long tickt_id;
    String alloted_seats;
    double amount;

    @NotNull
    ShowDTO showDTO;

    @NotNull
    UserDTO userDTO;
}
