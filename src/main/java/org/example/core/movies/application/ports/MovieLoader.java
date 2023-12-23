package org.example.core.movies.application.ports;

import org.example.core.movies.domain.Movie;

import java.util.List;

public interface MovieLoader {
    List<Movie> load();
}
