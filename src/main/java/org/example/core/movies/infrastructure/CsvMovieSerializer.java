package org.example.core.movies.infrastructure;

import org.example.core.movies.domain.Movie;
import org.example.core.movies.domain.ports.MovieSerializer;

public class CsvMovieSerializer implements MovieSerializer {
    @Override
    public Movie serialize(String data) {
        var splittedData = data.split(",");
        return serialize(splittedData);
    }

    private Movie serialize(String[] splittedData) {
        return new Movie(
                splittedData[0],
                splittedData[1],
                splittedData[2],
                Integer.parseInt(splittedData[3]),
                Double.parseDouble(splittedData[4])
        );
    }
}
