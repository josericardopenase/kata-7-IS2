package org.example.core.charts.application.ports;

import java.util.List;

public interface DataLoader <Model>{
    List<Model> load();
}
