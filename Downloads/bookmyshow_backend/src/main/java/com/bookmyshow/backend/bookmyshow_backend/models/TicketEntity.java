package com.bookmyshow.backend.bookmyshow_backend.models;

import com.bookmyshow.backend.bookmyshow_backend.models.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticket_id;
    private String alloted_Seats;
    private double amount;

    @CreationTimestamp
    public Date createdOn;

    @ManyToOne
    @JoinColumn // it will add the primary key of UserEntity
    @JsonIgnore // as we need not to pass the user at the time of creation of a ticket obj
    private UserEntity user; // foreign key that will connect to the user table

    // showEntity
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity show;

    // List<ShowSeats>
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> showSeatsEntityList;

}
