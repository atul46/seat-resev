package com.superops.tickets.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieTicketId implements Serializable {

    @Id
    @Column(name = "movie_id")
    private String movieId;

    @Id
    @Column(name="theater_id")
    private String theaterId;

    @Id
    @Column(name="user_id")
    private String userId;


}
