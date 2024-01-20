package org.example.core.charts.infrastructure.loaders;

import org.example.core.charts.application.ports.DataLoader;
import org.example.core.charts.application.ports.ModelSerializer;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataLoader<Model> implements DataLoader<Model> {
    private final String path;
    private final ModelSerializer<Model> serializer;

    public FileDataLoader(String path, ModelSerializer<Model> serializer) {
        this.path = path;
        this.serializer = serializer;
    }

    @Override
    public List<Model> load() {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            return load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Model> load(BufferedReader reader) {
        return reader.lines()
                .skip(1)
                .map(x -> serializer.deserialize(new ModelSerializer.Input() {
                    @Override
                    public String get(String key) {
                        return null;
                    }

                    @Override
                    public String get(int index) {
                        return x.split(",")[index];
                    }
                }))
                .collect(Collectors.toList());
    }
}
