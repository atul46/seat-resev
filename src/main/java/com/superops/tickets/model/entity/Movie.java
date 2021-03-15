package com.superops.tickets.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "movies_user")
@Data
@EqualsAndHashCode
@IdClass(MovieTheaterId.class)
public class Movie implements Serializable {

    @Id
    @Column(name="movie_id")
    private String movieId;

    @Id
    @Column(name="theater_id")
    private String theaterId;

    @Column(name="movie_name")
    private String movieName;

    @Column(name="status")
    private Status status;

    @ManyToOne
    private Theater movies;





}
