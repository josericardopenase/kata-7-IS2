package org.example.core.shared.application.useCases;

import org.example.core.shared.application.ports.ChartProcessor;
import org.example.core.shared.application.ports.DataLoader;
import org.example.core.shared.domain.Chart;

public class ChartCreator<Model, Data> {
    private final ChartProcessor<Model, Data> processor;
    private final DataLoader<Model> loader;


    public ChartCreator(ChartProcessor<Model, Data> processor, DataLoader<Model> loader) {
        this.processor = processor;
        this.loader = loader;
    }

    public Chart<Data> create(){
        var data = this.loader.load();
        return this.processor.process(data);
    }
}
