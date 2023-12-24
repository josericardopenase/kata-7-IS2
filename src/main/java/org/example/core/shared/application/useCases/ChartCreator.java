package org.example.core.shared.application.useCases;

import org.example.core.movies.domain.Movie;
import org.example.core.shared.application.ports.ChartProcessor;
import org.example.core.shared.application.ports.DataLoader;
import org.example.core.shared.domain.Chart;
import org.example.core.shared.infrastructure.loaders.FileDataLoader;
import org.example.core.shared.infrastructure.processors.HistogramChartProcessor;

public class ChartCreator<Model, Data> {
    private final ChartProcessor<Model, Data> processor;
    private final DataLoader<Model> loader;


    public ChartCreator(DataLoader<Model> loader, ChartProcessor<Model, Data> processor) {
        this.processor = processor;
        this.loader = loader;
    }

    public Chart<Data> create(){
        var data = this.loader.load();
        return this.processor.process(data);
    }
}
