package org.example.core.movies.infrastructure;

import org.example.core.charts.application.ports.ModelSerializer;
import org.example.core.movies.domain.Movie;

public class MovieCsvSerializer implements ModelSerializer<Movie> {
    @Override
    public Movie serialize(String data) {
        var splittedData = data.split(",");
        return new Movie(
                splittedData[0],
                splittedData[1],
                splittedData[2],
                Integer.parseInt(splittedData[3]),
                Double.parseDouble(splittedData[4])
        );
    }
}
