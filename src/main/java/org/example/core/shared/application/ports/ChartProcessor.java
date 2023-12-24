package org.example.core.shared.application.ports;

import org.example.core.shared.domain.Chart;

import java.util.List;

public interface ChartProcessor<Model, DataStructure> {
    Chart<DataStructure> process(List<Model> sourceData);
}
