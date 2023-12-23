package org.example.core.statistics.infrastructure.processors;

import org.example.core.statistics.application.ports.StatisticProcessor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;

public class HistogramStatisticProcessor<M> implements StatisticProcessor<Map<String, M>, M> {

    private final Function<? super M, String> field;
    private final Collector<? super M, ? extends Object, M> collector;

    public static class HistogramStatisticProcessorBuilder<M>{
        private Function<? super M, String> field;
        private Collector<? super M, ? extends Object, M> collector;

        private HistogramStatisticProcessorBuilder<M> groupedBy(Function<? super M, String> field){
            this.field = field;
            return this;
        }

        private HistogramStatisticProcessorBuilder<M> groupedBy(Collector<? super M, ? extends Object, M> collector){
            this.collector = collector;
            return this;
        }

        private HistogramStatisticProcessor<M> build(){
            return new HistogramStatisticProcessor<>(this.field, this.collector);
        }


    }

    private HistogramStatisticProcessor(Function<? super M, String> field, Collector<? super M, ?, M> collector) {
        this.field = field;
        this.collector = collector;
    }

    @Override
    public Map<String, M> process(List<M> data) {
        return data.stream()
                .collect(groupingBy(field, collector));
    }
}
