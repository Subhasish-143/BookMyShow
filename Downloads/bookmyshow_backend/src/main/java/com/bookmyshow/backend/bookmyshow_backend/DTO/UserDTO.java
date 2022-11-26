package com.bookmyshow.backend.bookmyshow_backend.DTO;

import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    int user_id;

    @NotNull
    String name;

    @NotNull
    String number;

    List<TicketDTO> listOfTicket;

}
