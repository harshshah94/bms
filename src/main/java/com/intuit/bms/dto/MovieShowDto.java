package com.intuit.bms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieShowDto {

    private Long movieId;
    private String title;
    private String duration;

    private List<ShowDto> shows;
}
