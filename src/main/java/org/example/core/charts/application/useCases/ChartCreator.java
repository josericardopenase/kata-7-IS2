package org.example.core.charts.application.useCases;

import org.example.core.charts.application.ports.ChartProcessor;
import org.example.core.charts.application.ports.DataLoader;
import org.example.core.charts.domain.Chart;

public class ChartCreator <Model, Data>{
    private DataLoader<Model> loader;
    private ChartProcessor<Model,Data> processor;

    public ChartCreator(DataLoader<Model> loader, ChartProcessor<Model, Data> processor) {
        this.loader = loader;
        this.processor = processor;
    }

    public Chart<Data> create(){
        var data = this.loader.load();
        return this.processor.process(data);

    }
}
