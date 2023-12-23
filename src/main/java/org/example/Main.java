package org.example;

import org.example.core.movies.application.useCases.MovieStatisticCreator;
import org.example.core.movies.infraestructure.loaders.MockMovieLoader;
import org.example.core.movies.infraestructure.statisticProcessors.HistogramMovieStatisticProcessor;

public class Main {
    public static void main(String[] args) {
        var loader = new MockMovieLoader();
        var processor = new HistogramMovieStatisticProcessor();
        var statisticCreator = new MovieStatisticCreator<>(loader, processor);
        var statistic = statisticCreator.create();
        System.out.println(statistic.data());
    }
}