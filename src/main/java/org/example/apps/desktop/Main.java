package org.example.apps.desktop;

import org.example.apps.desktop.application.BarChartScreen;
import org.example.apps.desktop.infrastructure.mock.MockBarChartDisplay;
import org.example.apps.desktop.infrastructure.swing.MainFrame;
import org.example.core.charts.application.useCases.ChartCreator;
import org.example.core.charts.infrastructure.loaders.FileDataLoader;
import org.example.core.charts.infrastructure.processors.BarChartProcessor;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.infrastructure.CsvMovieSerializer;
import org.example.core.users.domain.User;
import org.example.core.users.infrastructure.CsvUserSerializer;

import java.awt.desktop.UserSessionEvent;
import java.util.Map;

import static java.util.stream.Collectors.averagingInt;

public class Main {
    public static void main(String[] args) {
        var creator = getChartCreator();
        var mainFrame = new MainFrame();
        var screen = new BarChartScreen<>(creator, mainFrame.getDisplay());
        screen.show();
        mainFrame.setVisible(true);
    }

    private static ChartCreator <User, Map<String, Double>> getChartCreator() {
        var serializer = new CsvUserSerializer();
        var loader = new FileDataLoader<>("users.csv", serializer);
        var processor = new BarChartProcessor<>(User::firstName, averagingInt(x -> x.password().length()));
        return new ChartCreator<>(loader, processor);
    }
}
