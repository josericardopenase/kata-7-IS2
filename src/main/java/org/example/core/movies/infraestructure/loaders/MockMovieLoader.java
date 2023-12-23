package org.example.core.movies.infraestructure.loaders;

import org.example.core.movies.application.ports.MovieLoader;
import org.example.core.movies.domain.Movie;

import java.util.List;

public class MockMovieLoader implements MovieLoader {
    @Override
    public List<Movie> load() {
        return null;
    }
}
