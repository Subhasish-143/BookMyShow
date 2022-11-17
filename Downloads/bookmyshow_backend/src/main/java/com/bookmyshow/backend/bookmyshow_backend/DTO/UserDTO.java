package com.bookmyshow.backend.bookmyshow_backend.DTO;

import com.sun.istack.NotNull;
import lombok.*;

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

}
