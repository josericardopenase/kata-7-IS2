package org.example.core.charts.infrastructure.loaders;

import org.example.core.charts.application.ports.DataLoader;
import org.example.core.charts.application.ports.ModelSerializer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataLoader<Model> implements DataLoader<Model> {

    private final ModelSerializer<Model> serializer;
    private final String path;

    public FileDataLoader(ModelSerializer<Model> serializer, String path) {
        this.serializer = serializer;
        this.path = path;
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
                .map(serializer::serialize)
                .collect(Collectors.toList());
    }
}
