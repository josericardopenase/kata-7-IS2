package org.example.core.charts.application.ports;

public interface ModelSerializer <Model>{
    Model deserialize(Input data);

    interface Input{
        String get(String key);
        String get(int index);
    }

}
