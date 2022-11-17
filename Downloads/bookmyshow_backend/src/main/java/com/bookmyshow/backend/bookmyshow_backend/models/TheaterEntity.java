package com.bookmyshow.backend.bookmyshow_backend.models;

import com.bookmyshow.backend.bookmyshow_backend.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Theater_table")
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theat_id;
    private String name;
    private String city;
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> listOfShows;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheaterSeatEntity> listOfTheaterSeat;
}
