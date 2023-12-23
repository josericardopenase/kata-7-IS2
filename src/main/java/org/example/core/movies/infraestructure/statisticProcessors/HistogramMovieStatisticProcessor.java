package org.example.core.movies.infraestructure.statisticProcessors;

import org.example.core.movies.application.ports.MovieStatisticProcessor;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.domain.Statistic;

import java.util.List;
import java.util.Map;

public class HistogramMovieStatisticProcessor implements MovieStatisticProcessor<Map<String, Double>> {
    @Override
    public Statistic<Map<String, Double>> process(List<Movie> movies) {
        return null;
    }
}
