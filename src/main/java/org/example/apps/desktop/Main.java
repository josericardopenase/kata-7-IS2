package org.example.apps.desktop;

import org.example.apps.desktop.application.BarChartScreen;
import org.example.apps.desktop.infraestructure.swing.MainFrame;
import org.example.core.charts.application.useCases.StatisticCreator;
import org.example.core.charts.infrastructure.loaders.FileDataLoader;
import org.example.core.charts.infrastructure.loaders.SqliteDataLoader;
import org.example.core.charts.infrastructure.processors.BarChartProcessor;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.infrastructure.MockMovieLoader;
import org.example.core.movies.infrastructure.MovieSerializer;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import static java.util.stream.Collectors.averagingInt;

public class Main {
    public static void main(String[] args) throws SQLException {
        var creator =  getChartCreator();
        var frame = new MainFrame();
        var screen = new BarChartScreen<>(frame.getDisplay(), creator);
        screen.show();
        frame.setVisible(true);
    }

    private static StatisticCreator<Movie, Map<String, Double>> getChartCreator() throws SQLException {
        var loader = new MockMovieLoader();
        var processor = new BarChartProcessor<>(Movie::genre, averagingInt(Movie::audienceScore));
        return new StatisticCreator<>(loader, processor);
    }
}
