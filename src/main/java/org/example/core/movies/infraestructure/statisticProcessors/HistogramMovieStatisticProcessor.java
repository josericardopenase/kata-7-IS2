package org.example.core.movies.infraestructure.statisticProcessors;

import org.example.core.movies.application.ports.MovieStatisticProcessor;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.domain.Statistic;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HistogramMovieStatisticProcessor implements MovieStatisticProcessor<Map<String, Double>> {


    private final Function<Movie, String> key;
    private final Collector<Movie, ?, Double> collector;

    public <T> HistogramMovieStatisticProcessor(Function<Movie, String> key, Collector<Movie,?, Double> collector) {
        this.key = key;
        this.collector = collector;
    }

    @Override
    public Statistic<Map<String, Double>> process(List<Movie> movie) {
        return new Statistic<>(movie.stream().collect(Collectors.groupingBy(key, collector)));
    }
}
