package com.bookmyshow.backend.bookmyshow_backend.DTO;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    long mov_id;
    String name;
    Date release_date;
    List<ShowDTO> showDTOList;
}
