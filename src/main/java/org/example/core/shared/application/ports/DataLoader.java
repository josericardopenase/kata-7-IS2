package org.example.core.shared.application.ports;

import java.util.List;

public interface DataLoader<Model> {
    List<Model> load();
}
