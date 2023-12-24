package org.example;


import org.example.core.movies.domain.Movie;
import org.example.core.movies.infraestructure.serializers.MovieCsvSerializer;
import org.example.core.shared.application.useCases.ChartCreator;
import org.example.core.shared.infrastructure.loaders.FileDataLoader;
import org.example.core.shared.infrastructure.processors.HistogramChartProcessor;
import org.example.core.users.domain.User;
import org.example.core.users.infraestructure.serializers.UserCsvSerializer;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.averagingInt;

public class Main {
    public static void main(String[] args) {
        var serializer = new UserCsvSerializer();
        var loader = new FileDataLoader<>(serializer, "users.csv");
        var processor = new HistogramChartProcessor<>(User::firstName, averagingDouble(x -> x.password().length()));
        var chartCreator = new ChartCreator<>(loader, processor);
        var chart = chartCreator.create();
        System.out.println(chart.data());
    }
}