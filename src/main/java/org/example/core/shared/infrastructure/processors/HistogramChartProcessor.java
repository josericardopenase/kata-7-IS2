package org.example.core.shared.infrastructure.processors;

import org.example.core.shared.application.ports.ChartProcessor;
import org.example.core.shared.domain.Chart;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;

public class HistogramChartProcessor<Model> implements ChartProcessor<Model, Map<String, Double>> {
    private final Function<Model,String> field;
    private final Collector<Model, ?,Double> collector;

    public HistogramChartProcessor(Function<Model, String> field, Collector<Model, ?, Double> collector) {
        this.field = field;
        this.collector = collector;
    }

    @Override
    public Chart<Map<String, Double>> process(List<Model> sourceData) {
        return new Chart<>(sourceData.stream()
                .collect(groupingBy(field, collector))
        );
    }
}
