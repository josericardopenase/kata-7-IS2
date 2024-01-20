package org.example.apps.restApi.movies.commands;

import org.example.apps.restApi.Command;
import org.example.core.charts.application.ports.DataLoader;
import org.example.core.charts.application.useCases.StatisticCreator;
import org.example.core.charts.domain.BarChart;
import org.example.core.charts.domain.Statistic;
import org.example.core.charts.infrastructure.processors.BarChartProcessor;
import org.example.core.movies.domain.Movie;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.averagingDouble;

public class BarChartMoviesCreatorCommand implements Command {
    private final DataLoader<Movie> loader;
    private final Map<String, Function<Movie, String>> groupingKeys = new HashMap<>();
    private final Map<String, Function<Movie, Double>> operableKeys = new HashMap<>();

    public BarChartMoviesCreatorCommand(DataLoader<Movie> loader) {
        this.loader = loader;
        fillGroupingKeys();
        fillOperableKeys();
    }

    private void fillOperableKeys() {
        operableKeys.put("audienceScore", x -> (double) x.audienceScore());
        operableKeys.put("profitability", Movie::profitability);
    }

    private void fillGroupingKeys() {
        groupingKeys.put("genre", Movie::genre);
        groupingKeys.put("studio", Movie::studio);
    }

    @Override
    public Output execute(Input input) {
        var statistic = getStatisticFrom(loader, input);
        return Command.output(chartFrom(statistic), 200);
    }

    private Statistic<Map<String, Double>> getStatisticFrom(DataLoader<Movie> loader, Input input) {
        var groupedBy = input.get("groupedBy");
        var operatedBy = input.get("operatedBy");
        if(notValidArgs(groupedBy, operatedBy)) return Statistic.empty();
        var creator = new StatisticCreator<>(
                loader,
                getMovieBarChartProcessor(groupedBy, operatedBy)
        );
        return creator.create();
    }

    private boolean notValidArgs(String groupedBy, String operatedBy) {
        if (groupedBy == null || operatedBy == null) return true;
        return groupedBy.isBlank() || groupedBy.isEmpty() || operatedBy.isBlank() || operatedBy.isEmpty();
    }

    private BarChartProcessor<Movie> getMovieBarChartProcessor(String groupedBy, String operatedBy) {
        return new BarChartProcessor<>(
                groupingKeys.get(groupedBy),
                averagingDouble(x -> operableKeys.get(operatedBy).apply(x)));
    }

    private BarChart chartFrom(Statistic<Map<String, Double>> statistic) {
        return BarChart.fromScratch()
                .setData(statistic)
                .build();
    }
}
