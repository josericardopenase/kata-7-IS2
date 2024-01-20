package org.example.core.charts.domain;

import java.util.HashMap;
import java.util.Map;

public record Statistic<Data>(
        Data data
) {
    public static <Data>Statistic of(Data data){
        return new Statistic<Data>(data);
    }

    public static Statistic<Map<String, Double>> empty() {
        return Statistic.of(new HashMap<>());
    }
}
