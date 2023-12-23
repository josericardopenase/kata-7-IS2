package org.example.core.statistics.infrastructure.processors;

public class StatisticProcessorBuilder {
    public static<M> HistogramStatisticProcessor.HistogramStatisticProcessorBuilder<M> histogram(){
       return new HistogramStatisticProcessor.HistogramStatisticProcessorBuilder<M>();
    }

}
