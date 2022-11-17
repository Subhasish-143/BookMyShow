package com.bookmyshow.backend.bookmyshow_backend.models;

import com.bookmyshow.backend.bookmyshow_backend.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Theater_seats")
public class TheaterSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Theat_Seat_id;
    private String seatNumber;
    private SeatType seatType;
    private int rate;

    // TheaterEntity
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TheaterEntity theater;

}
