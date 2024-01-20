package org.example.apps.desktop;

import org.example.apps.desktop.application.BarChartDisplay;
import org.example.apps.desktop.application.BarChartScreen;
import org.example.apps.desktop.infraestructure.mock.MockBarChartDisplay;
import org.example.core.charts.application.useCases.ChartCreator;
import org.example.core.charts.infrastructure.loaders.FileDataLoader;
import org.example.core.charts.infrastructure.processors.BarChartProcessor;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.infrastructure.CsvMovieSerializer;

import java.util.Map;

import static java.util.stream.Collectors.averagingInt;

public class Main {
    public static void main(String[] args) {
        var creator =  getChartCreator();
        var display = new MockBarChartDisplay();
        var screen = new BarChartScreen<>(display, creator);
        screen.show();
    }

    private static ChartCreator<Movie, Map<String, Double>> getChartCreator() {
        var serializer = new CsvMovieSerializer();
        var loader = new FileDataLoader<>("movies.csv", serializer);
        var processor = new BarChartProcessor<>(Movie::genre, averagingInt(Movie::audienceScore));
        return new ChartCreator<>(loader, processor);
    }
}
