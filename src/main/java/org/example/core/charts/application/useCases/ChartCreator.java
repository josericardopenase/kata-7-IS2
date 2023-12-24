package org.example.core.charts.application.useCases;

import org.example.core.charts.application.ports.ChartProcessor;
import org.example.core.charts.application.ports.DataLoader;
import org.example.core.charts.domain.Chart;

public class ChartCreator<Model, DataStructure> {
    private final DataLoader<Model> loader;
    private final ChartProcessor<Model, DataStructure> processor;

    public ChartCreator(DataLoader<Model> loader, ChartProcessor<Model, DataStructure> processor) {
        this.loader = loader;
        this.processor = processor;
    }

    public Chart<DataStructure> create(){
        var data = this.loader.load();
        return this.processor.process(data);
    }
}
