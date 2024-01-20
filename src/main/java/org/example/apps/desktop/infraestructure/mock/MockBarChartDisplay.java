package org.example.apps.desktop.infraestructure.mock;

import org.example.apps.desktop.application.BarChartDisplay;
import org.example.core.charts.domain.BarChart;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockBarChartDisplay implements BarChartDisplay {

    @Override
    public void display(BarChart barChart) {
        System.out.println("x AXIS: " + barChart.xAxisTitle());
        System.out.println(getValueList(barChart.statistic().data()));
        System.out.println("Y AXIS: " + barChart.yAxisTitle());
        System.out.println(getLabelList(barChart.statistic().data()));
    }

    private List<String> getLabelList(Map<String, Double> data) {
        return data.keySet().stream()
                .toList();
    }

    private List<Double> getValueList(Map<String, Double> data) {
        return data.keySet().stream()
                .map(x -> data.get(x))
                .collect(Collectors.toList());
    }
}
