package org.example.apps.desktop.domain;

import java.util.Map;

public record BarChart(
        String title,
        String yAxisTitle,
        String xAxisTitle,
        Map<String, Double> data
) {
    public static BarChartBuilder fromScratch(){
        return new BarChartBuilder();
    }

    public static class BarChartBuilder{
        String title;

        public BarChartBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BarChartBuilder setyAxisTitle(String yAxisTitle) {
            this.yAxisTitle = yAxisTitle;
            return this;
        }

        public BarChartBuilder setxAxisTitle(String xAxisTitle) {
            this.xAxisTitle = xAxisTitle;
            return this;
        }

        public BarChartBuilder setData(Map<String, Double> data) {
            this.data = data;
            return this;
        }

        String yAxisTitle;
        String xAxisTitle;
        Map<String, Double> data;

    public BarChart build(){
        return new BarChart(
                this.title,
                this.yAxisTitle,
                this.xAxisTitle,
                this.data
        );
    }

    }
}
