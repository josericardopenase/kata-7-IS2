package org.example.core.movies.infraestructure.serializers;

import org.example.core.movies.domain.Movie;
import org.example.core.shared.application.ports.Serializer;

public class MovieCsvSerializer implements Serializer<Movie> {
    @Override
    public Movie serialize(String sourceData) {
        var splittedData = sourceData.split(",");
        return new Movie(
                splittedData[0],
                splittedData[1],
                splittedData[2],
                Integer.parseInt(splittedData[3]),
                Double.parseDouble(splittedData[4])
        );
    }
}
