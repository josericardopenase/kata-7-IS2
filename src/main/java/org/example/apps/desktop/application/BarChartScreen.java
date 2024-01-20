package org.example.apps.desktop.application;

import org.example.core.charts.domain.BarChart;
import org.example.core.charts.application.useCases.StatisticCreator;
import org.example.core.charts.domain.Statistic;

import java.util.Map;

public class BarChartScreen<Model> implements Screen{
    public BarChartScreen(BarChartDisplay display, StatisticCreator<Model, Map<String, Double>> creator) {
        this.display = display;
        this.creator = creator;
    }

    BarChartDisplay display;
    StatisticCreator<Model, Map <String, Double>> creator;



    @Override
    public void show() {
        var chart = this.creator.create();
        var barChart = chartToBarChart(chart);
        display.display(barChart);
    }

    private BarChart chartToBarChart(Statistic<Map<String, Double>> chart) {
        return BarChart.fromScratch()
                .setTitle("BarChart")
                .setxAxisTitle("X axis")
                .setyAxisTitle("Y axis")
                .setData(chart)
                .build();
    }
}
