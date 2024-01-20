package org.example.apps.desktop.infrastructure.mock;

import org.example.apps.desktop.application.BarChartDisplay;
import org.example.apps.desktop.domain.BarChart;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockBarChartDisplay implements BarChartDisplay {
    @Override
    public void display(BarChart barChart) {
        System.out.println("Xaxis: " + barChart.xAxisTitle());
        System.out.println(getValueList(barChart.data()));
        System.out.println("Yaxis: " + barChart.yAxisTitle());
        System.out.println(getLabelList(barChart.data()));
    }

    private List<String> getLabelList(Map<String, Double> data) {
        return data.keySet().stream().collect(Collectors.toList());
    }

    private List<Double> getValueList(Map<String, Double> data) {
        return data.keySet().stream().map(x -> data.get(x)).collect(Collectors.toList());
    }
}
