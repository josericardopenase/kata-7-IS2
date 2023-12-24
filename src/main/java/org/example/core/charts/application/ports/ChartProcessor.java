package org.example.core.charts.application.ports;

import org.example.core.charts.domain.Chart;

import java.util.List;

public interface ChartProcessor<Model, Data> {
    Chart<Data> process(List<Model> sourceData);
}
