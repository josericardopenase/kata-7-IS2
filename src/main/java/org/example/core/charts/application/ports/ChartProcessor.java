package org.example.core.charts.application.ports;

import org.example.core.charts.domain.Chart;

import java.util.List;

public interface ChartProcessor<Model, DataStructure> {
    Chart<DataStructure> process(List<Model> sourceData);
}
