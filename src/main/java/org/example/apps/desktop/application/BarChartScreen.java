package org.example.apps.desktop.application;

import org.example.apps.desktop.domain.BarChart;
import org.example.core.charts.application.useCases.ChartCreator;

import java.util.Map;

public class BarChartScreen<Model> implements Screen{

    private final ChartCreator<Model, Map<String, Double>> creator;
    private final BarChartDisplay display;

    public BarChartScreen(ChartCreator<Model, Map<String, Double>> creator, BarChartDisplay display) {
        this.creator = creator;
        this.display = display;
    }

    @Override
    public void show() {
        var chart = this.creator.create();
        var barChart = BarChart.fromScratch()
                .setTitle("BarChart")
                .setxAxisTitle("x axis")
                .setyAxisTitle("y axis")
                .setData(chart.data())
                .build();
        this.display.display(barChart);
    }
}
