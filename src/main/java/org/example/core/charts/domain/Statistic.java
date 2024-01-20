package org.example.core.charts.domain;

public record Statistic<Data>(
        Data data
) {
    public static <Data>Statistic of(Data data){
        return new Statistic<Data>(data);
    }
}
