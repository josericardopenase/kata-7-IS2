package org.example.core.charts.application.ports;

import org.example.core.charts.domain.Statistic;

import java.util.List;

public interface StatisticProcessor<Model, Data> {
    Statistic<Data> process(List<Model> sourceData);
}
