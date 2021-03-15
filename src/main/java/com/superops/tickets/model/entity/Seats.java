package com.superops.tickets.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="seats")
@Data
@IdClass(MovieTicketId.class)
public class Seats implements Serializable {



    @Id
    @Column(name="seat_id")
    private Integer seatId;

    @Id
    @Column(name="user_id")
    private String userId;

    @Id
    @Column(name = "movie_id")
    private String movieId;

    @Id
    @Column(name="theatre_id")
    private String theaterId;

    @ManyToOne()
    private SeatBooking seat;

}
