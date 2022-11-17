package com.bookmyshow.backend.bookmyshow_backend.models;

import com.bookmyshow.backend.bookmyshow_backend.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Show_seats")
public class ShowSeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long show_seat_id;
    private String seatNumber;
    private SeatType seatType;
    private int rate;
    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bookedAt;

    // ShowEntity
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    ShowEntity show;

    // TicketEntity
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    TicketEntity ticket;
}
