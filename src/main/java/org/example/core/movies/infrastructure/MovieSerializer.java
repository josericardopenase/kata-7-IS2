package org.example.core.movies.infrastructure;

import org.example.core.charts.application.ports.ModelSerializer;
import org.example.core.movies.domain.Movie;

public class MovieSerializer implements ModelSerializer<Movie> {

    @Override
    public Movie deserialize(Input data) {
        return new Movie(
                data.get(0),
                data.get(1),
                data.get(2),
                Integer.parseInt(data.get(3)),
                Double.parseDouble(data.get(4))
        );
    }
}
