package com.bookmyshow.backend.bookmyshow_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Show_table")
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long show_id;
    private LocalDate showDate;
    private LocalTime showtime;

    @CreationTimestamp
    public Date creating_on;

    @UpdateTimestamp
    public Date updating_on;

    // list<TicketEntity>
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketEntity> listOfTickets;

    // List<ShowSeats>
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> listOfShowSeats;

    // Movie
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    MovieEntity movie;

    // Theater
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    TheaterEntity theater;
}
