package org.example.apps.desktop.infraestructure.swing;

import org.example.apps.desktop.application.BarChartDisplay;
import org.example.core.charts.domain.BarChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;

public class SwingBarChartDisplay extends JPanel implements BarChartDisplay {
    @Override
    public void display(BarChart barChart) {
        add(panelFrom(barChart));
        setVisible(true);
    }

    private JPanel panelFrom(BarChart barChart) {
        return new ChartPanel(
                ChartFactory.createBarChart(
                        barChart.title(),
                        barChart.xAxisTitle(),
                        barChart.yAxisTitle(),
                        datasetFrom(barChart.statistic().data())
                )
        );
    }

    private CategoryDataset datasetFrom(Map<String, Double> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        data.keySet().forEach(x -> dataset.addValue(data.get(x), "", x));
        return dataset;
    }
}
