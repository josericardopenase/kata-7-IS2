package org.example.core.movies.infraestructure.statisticProcessors;

import org.example.core.movies.application.ports.MovieStatisticProcessor;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.domain.Statistic;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;

public class HistogramMovieStatisticProcessor implements MovieStatisticProcessor<Map<String, Double>> {
    private final Collector<Movie,?, Double> collector;
    private final Function<Movie, String> field;

    public HistogramMovieStatisticProcessor(Function<Movie, String> field, Collector<Movie,?, Double> collector) {
        this.field = field;
        this.collector = collector;
    }

    @Override
    public Statistic<Map<String, Double>> process(List<Movie> moviesToProcess) {
        return new Statistic<>(
                moviesToProcess.stream()
                        .collect(groupingBy(this.field, this.collector))
        );
    }
}
