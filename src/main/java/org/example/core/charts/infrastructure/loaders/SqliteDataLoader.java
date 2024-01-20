package org.example.core.charts.infrastructure.loaders;

import org.example.core.charts.application.ports.DataLoader;

import java.util.List;

public class SqliteDataLoader<Model> implements DataLoader<Model> {
    @Override
    public List<Model> load() {
        return null;
    }
}
