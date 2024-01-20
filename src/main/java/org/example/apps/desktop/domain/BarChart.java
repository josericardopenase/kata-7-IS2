package org.example.apps.desktop.domain;

import java.util.Map;

public record BarChart (
        String title,
        String xAxisTitle,
        String yAxisTitle,
        Map<String, Double> data
){
    public static BarChartBuilder fromScratch(){
        return new BarChartBuilder();
    }
    public static class BarChartBuilder {
        private String title;
        private String xAxisTitle;
        private String yAxisTitle;

        public BarChartBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BarChartBuilder setxAxisTitle(String xAxisTitle) {
            this.xAxisTitle = xAxisTitle;
            return this;
        }

        public BarChartBuilder setyAxisTitle(String yAxisTitle) {
            this.yAxisTitle = yAxisTitle;
            return this;
        }

        public BarChartBuilder setData(Map<String, Double> data) {
            this.data = data;
            return this;
        }

        private Map<String, Double> data;

        public BarChart build(){
            return new BarChart(
                    this.title,
                    this.xAxisTitle,
                    this.yAxisTitle,
                    this.data
            );
        }

    }
}
