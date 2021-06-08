package com.intuit.bms.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer addressId;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
