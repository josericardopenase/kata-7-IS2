package org.example.apps.restApi.movies.commands;

import org.example.apps.restApi.Command;
import org.example.core.charts.application.ports.DataLoader;
import org.example.core.charts.application.useCases.StatisticCreator;
import org.example.core.charts.domain.BarChart;
import org.example.core.charts.domain.Statistic;
import org.example.core.movies.domain.Movie;

import java.util.Map;

public class BarChartMoviesCreatorCommand implements Command {
    private final StatisticCreator<Movie, Map<String, Double>> creator;

    public BarChartMoviesCreatorCommand(StatisticCreator<Movie, Map<String, Double>> creator) {
        this.creator = creator;
    }

    @Override
    public Output execute(Input input) {
        var statistic = creator.create();
        return Command.output(chartFrom(statistic), 200);
    }

    private BarChart chartFrom(Statistic<Map<String, Double>> statistic) {
        return BarChart.fromScratch()
                .setData(statistic)
                .build();
    }
}
