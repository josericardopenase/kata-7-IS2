package org.example.core.charts.infrastructure.processors;

import org.example.core.charts.application.ports.ChartProcessor;
import org.example.core.charts.domain.Chart;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BarChartProcessor<Model> implements ChartProcessor<Model, Map<String, Double>> {
    private Function<Model, String> field;
    private Collector<Model, ? extends Object, Double> collector;

    public BarChartProcessor(Function<Model, String> field, Collector<Model, ? extends Object, Double> collector) {
        this.field = field;
        this.collector = collector;
    }

    @Override
    public Chart<Map<String, Double>> process(List<Model> sourceData) {
        return new Chart(sourceData.stream().collect(Collectors.groupingBy(field, collector)));
    }
}
