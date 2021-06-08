package com.intuit.bms.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@Entity
public class Cinema {

    @Id
    @GeneratedValue
    private Integer cinemaId;
    private String cinemaName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "cinema")
    private Set<CinemaHall> cinemaHalls = new HashSet<>();

}
