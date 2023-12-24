package org.example.core.shared.infrastructure.loaders;

import org.example.core.shared.application.ports.DataLoader;
import org.example.core.shared.application.ports.Serializer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataLoader<Model> implements DataLoader<Model> {
    private final Serializer<Model> serializer;
    private final String path;

    public FileDataLoader(Serializer<Model> serializer, String path) {
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
