package org.example.apps.desktop.infrastructure.mock;

import org.example.apps.desktop.application.BarChartDisplay;
import org.example.apps.desktop.domain.BarChart;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockBarChartDisplay implements BarChartDisplay {
    @Override
    public void display(BarChart barChart) {
        System.out.println("Y axis: " + barChart.yAxisTitle());
        System.out.println(getValues(barChart.data()));
        System.out.println("X axis: " + barChart.xAxisTitle());
        System.out.println(getLabels(barChart.data()));
    }

    private List<String> getLabels(Map<String, Double> data) {
        return data.keySet().stream()
                .collect(Collectors.toList());
    }

    private List<Double> getValues(Map<String, Double> data) {
        return data.keySet().stream()
                .map(x -> data.get(x))
                .collect(Collectors.toList());
    }
}
