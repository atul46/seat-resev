package com.superops.tickets.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="seat_booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MovieTicketId.class)
public class SeatBooking implements Serializable {

    @Id
    @Column(name="user_id")
    private String userId;

    @Id
    @Column(name = "movie_id")
    private String movieId;

    @Id
    @Column(name="theatre_id")
    private String theaterId;


    @Column(name="movie_name")
    private String movieName;


    @OneToMany(mappedBy = "seat")
    private List<Seats> seats;


    @Column(name="amt")
    int amount;

    @Column(name="payment_status")
    Status statusOfPayment;

    @Column(name="booked_date")
    Date bookedDate;


    @Column(name="movie_timing")
    String movieTiming;
}
