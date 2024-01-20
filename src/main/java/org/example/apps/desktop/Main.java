package org.example.apps.desktop;

import org.example.apps.desktop.application.BarChartScreen;
import org.example.apps.desktop.infraestructure.swing.MainFrame;
import org.example.core.charts.application.useCases.ChartCreator;
import org.example.core.charts.infrastructure.loaders.FileDataLoader;
import org.example.core.charts.infrastructure.processors.BarChartProcessor;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.infrastructure.CsvMovieSerializer;
import org.example.core.users.domain.User;
import org.example.core.users.infrastructure.CsvUserSerializer;

import java.util.Map;

import static java.util.stream.Collectors.averagingInt;

public class Main {
    public static void main(String[] args) {
        var creator =  getChartCreator();
        var frame = new MainFrame();
        var screen = new BarChartScreen<>(frame.getDisplay(), creator);
        screen.show();
        frame.setVisible(true);
    }

    private static ChartCreator<Movie, Map<String, Double>> getChartCreator() {
        var serializer = new CsvMovieSerializer();
        var loader = new FileDataLoader<>("movies.csv", serializer);
        var processor = new BarChartProcessor<>(Movie::genre, averagingInt(Movie::audienceScore));
        return new ChartCreator<>(loader, processor);
    }
}
