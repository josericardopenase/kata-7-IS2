package org.example.apps.desktop.infrastructure.swing;

import org.example.apps.desktop.application.BarChartDisplay;

import javax.swing.*;

public class MainFrame extends JFrame {
    public BarChartDisplay getDisplay() {
        return display;
    }

    private BarChartDisplay display;
    public MainFrame(){
        this.setTitle("BarChart");
        this.setSize(800, 600);
        add(createDisplay());
    }



    private SwingBarChartDisplay createDisplay() {
        this.display = new SwingBarChartDisplay();
        return (SwingBarChartDisplay) display;
    }
}
