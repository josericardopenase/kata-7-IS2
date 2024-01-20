package org.example;

import org.example.core.charts.application.useCases.ChartCreator;
import org.example.core.charts.infrastructure.loaders.FileDataLoader;
import org.example.core.charts.infrastructure.processors.BarChartProcessor;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.infrastructure.CsvMovieSerializer;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.util.stream.Collectors.averagingInt;

public class Main {
    public static void main(String[] args) throws SQLException {
        var connection = DriverManager.getConnection("jdbc:sqlite:moves.sqlite");
        var serializer = new CsvMovieSerializer();
        var loader = new FileDataLoader<>("movies.csv", serializer);
        var processor = new BarChartProcessor<>(Movie::genre, averagingInt(Movie::audienceScore));
        var chartCreator = new ChartCreator<>(loader, processor);
        var chart = chartCreator.create();
        System.out.println(chart.data());
    }
}