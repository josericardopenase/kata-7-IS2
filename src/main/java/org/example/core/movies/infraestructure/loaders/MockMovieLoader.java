package org.example.core.movies.infraestructure.loaders;

import org.example.core.movies.application.ports.MovieLoader;
import org.example.core.movies.domain.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockMovieLoader implements MovieLoader {
    @Override
    public List<Movie> load() {
        List<Movie> movies = new ArrayList<>();
        return load(movies);
    }

    private List<Movie> load(List<Movie> movies) {
        return IntStream.range(0, 20).mapToObj(this::createMockMovie).collect(Collectors.toList());
    }

    private Movie createMockMovie(int i) {
        return new Movie(
                "nombre mock",
                "terror",
                "mock",
                70 *i,
                20.0 * i
        );
    }
}
