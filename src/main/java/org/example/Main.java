package org.example;

import org.example.core.movies.application.useCases.MovieStatisticCreator;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.infraestructure.loaders.CsvFileMovieLoader;
import org.example.core.movies.infraestructure.statisticProcessors.HistogramMovieStatisticProcessor;
import static java.util.stream.Collectors.averagingDouble;

public class Main {
    public static void main(String[] args) {
    }
}