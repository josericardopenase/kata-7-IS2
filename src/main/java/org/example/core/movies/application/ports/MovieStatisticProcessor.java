package org.example.core.movies.application.ports;

import org.example.core.movies.domain.Movie;
import org.example.core.movies.domain.Statistic;

import java.util.List;

public interface MovieStatisticProcessor<T> {
    public Statistic<T> process(List<Movie> moviesToProcess);
}
