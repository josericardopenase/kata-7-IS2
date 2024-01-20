package org.example.apps.desktop.application;

import org.example.apps.desktop.domain.BarChart;
import org.example.core.charts.application.useCases.ChartCreator;
import org.example.core.charts.domain.Chart;

import java.util.Map;

public class BarChartScreen<Model> implements Screen{
    BarChartDisplay display;
    ChartCreator<Model, Map <String, Double>> creator;
    @Override
    public void show() {
        var chart = this.creator.create();
        var barChart = chartToBarChart(chart);
        display.display(barChart);
    }

    private BarChart chartToBarChart(Chart<Map<String, Double>> chart) {
        return BarChart.fromScratch()
                .setTitle("BarChart")
                .setxAxisTitle("X axis")
                .setyAxisTitle("Y axis")
                .setData(chart.data())
                .build();
    }
}
