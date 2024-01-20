package org.example.core.movies.infrastructure;

import org.example.core.charts.application.ports.ModelSerializer;
import org.example.core.movies.domain.Movie;

public class CsvMovieSerializer implements ModelSerializer<Movie> {

    @Override
    public Movie serialize(String data) {
        var splitted = data.split(",");
        return new Movie(
                splitted[0],
                splitted[1],
                splitted[2],
                Integer.parseInt(splitted[3]),
                Double.parseDouble(splitted[4])
        );
    }
}
