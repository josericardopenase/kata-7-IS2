package org.example;

import org.example.core.charts.application.useCases.ChartCreator;
import org.example.core.charts.infrastructure.loaders.FileDataLoader;
import org.example.core.charts.infrastructure.processors.BarChartProcessor;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.infrastructure.CsvMovieSerializer;
import org.example.core.users.domain.User;
import org.example.core.users.infrastructure.CsvUserSerializer;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.averagingInt;

public class Main {
    public static void main(String[] args) {
        var serializer = new CsvUserSerializer();
        var loader = new FileDataLoader<>("movies.csv", serializer);
        var processor = new BarChartProcessor<>(User::firstName, averagingInt(x-> x.password().length()));
        var chartCreator = new ChartCreator<>(loader, processor);
        var chart = chartCreator.create();
        System.out.println(chart.data());
    }
}