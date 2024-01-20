package org.example.apps.desktop.infraestructure.swing;

import org.example.apps.desktop.application.BarChartDisplay;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public BarChartDisplay getDisplay() {
        return display;
    }

    private BarChartDisplay display;
    public MainFrame(){
        setTitle("BarChart");
        setSize(800, 600);
        setVisible(true);
        add(createDisplay());
    }

    private JPanel createDisplay() {
        this.display = new SwingBarChartDisplay();
        return (JPanel) display;
    }
}
