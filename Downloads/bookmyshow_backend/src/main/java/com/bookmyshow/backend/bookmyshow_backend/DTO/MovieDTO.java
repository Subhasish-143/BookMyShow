package com.bookmyshow.backend.bookmyshow_backend.DTO;

import com.sun.istack.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    int mov_id;

    @NotNull
    String name;

    @NotNull
    Date release_date;

    List<ShowDTO> showDTOList;
}
