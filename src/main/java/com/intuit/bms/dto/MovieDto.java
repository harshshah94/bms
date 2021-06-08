package com.intuit.bms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {

    private Long movieId;
    private String title;
    private String duration;
}
