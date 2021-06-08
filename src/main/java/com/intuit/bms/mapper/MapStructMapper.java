package com.intuit.bms.mapper;

import com.intuit.bms.dto.MovieDto;
import com.intuit.bms.model.Movie;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring" )
public interface MapStructMapper {

    MovieDto movieToMovieDto(Movie movie);

//    MovieShowDto movieToMovieShowDto(Movie movie);

}
