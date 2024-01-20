package org.example.core.charts.application.useCases;

import org.example.core.charts.application.ports.StatisticProcessor;
import org.example.core.charts.application.ports.DataLoader;
import org.example.core.charts.domain.Statistic;

public class StatisticCreator<Model, Data>{
    private DataLoader<Model> loader;
    private StatisticProcessor<Model,Data> processor;

    public StatisticCreator(DataLoader<Model> loader, StatisticProcessor<Model, Data> processor) {
        this.loader = loader;
        this.processor = processor;
    }

    public Statistic<Data> create(){
        var data = this.loader.load();
        return this.processor.process(data);

    }
}
