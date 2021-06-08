package com.intuit.bms.exception;

public class MovieException extends Exception{

    public MovieException(String message) {
        super(message);
    }

    public static String NotFoundException(String id)
    {
        return "Movie with "+id+" not found";
    }

    public static String TitleEmptyException() {return "Movie title is null";}

    public static String TitleAlreadyExists()
    {
        return "Movie with given title already exists";
    }
}
