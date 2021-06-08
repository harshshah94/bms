package com.intuit.bms.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ShowDto {

    private Integer showId;
    private LocalDate createdOn;
    private LocalDateTime startTime;

}
