package com.superops.tickets.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "theater")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Theater {

    @Id
    @Column(name = "theater_id")
    private String theaterId;


    @OneToMany(mappedBy = "movies")
    private List<Movie> movies;


}
