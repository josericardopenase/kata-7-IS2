package org.example.core.charts.domain;

import java.util.Map;

public record BarChart(
        String title,
        String xAxisTitle,
        String yAxisTitle,
        Statistic<Map<String, Double>> statistic
) {
    public static BarChartBuilder fromScratch() {
        return new BarChartBuilder();
    }

    public static class BarChartBuilder{
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

        public BarChartBuilder setData(Statistic statistic) {
            this.statistic = statistic;
            return this;
        }

        private Statistic statistic;

        public BarChart build(){
            return new BarChart(
                    this.title,
                    this.xAxisTitle,
                    this.yAxisTitle,
                    this.statistic
            );
        }
    }
}
