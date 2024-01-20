package org.example.apps.desktop.application;

import org.example.apps.desktop.domain.BarChart;
import org.example.core.charts.application.useCases.ChartCreator;
import org.example.core.charts.domain.Chart;

import java.util.Map;

public class BarChartScreen<Model> implements Screen {
    private final BarChartDisplay display;
    private final ChartCreator<Model, Map<String, Double>> creator;

    public BarChartScreen(BarChartDisplay display, ChartCreator<Model, Map<String, Double>> creator) {
        this.display = display;
        this.creator = creator;
    }


    @Override
    public void show() {
        var chart = this.creator.create();
        var barChart = this.chartToBarChart(chart);
        this.display.display(barChart);
    }

    private BarChart chartToBarChart(Chart<Map<String, Double>> chart) {
        return BarChart.fromScratch()
                .setTitle("BarChartExample")
                .setxAxisTitle("X axis")
                .setyAxisTitle("Y axis")
                .build();
    }
}
