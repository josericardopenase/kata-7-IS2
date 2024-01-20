package org.example.apps.desktop.domain;

import java.util.Map;

public record BarChart (
        String title,
        String xAxisTitle,
        String yAxisTitle,
        Map<String, Double> data
){
    public static BarChartCreator fromScratch(){
        return new BarChartCreator();
    }
    public static class BarChartCreator{
        private String title;
        private String xAxisTitle;
        private String yAxisTitle;

        public BarChartCreator setTitle(String title) {
            this.title = title;
            return this;
        }

        public BarChartCreator setxAxisTitle(String xAxisTitle) {
            this.xAxisTitle = xAxisTitle;
            return this;
        }

        public BarChartCreator setyAxisTitle(String yAxisTitle) {
            this.yAxisTitle = yAxisTitle;
            return this;
        }

        public BarChartCreator setData(Map<String, Double> data) {
            this.data = data;
            return this;
        }

        private Map<String, Double> data;

    }
}
