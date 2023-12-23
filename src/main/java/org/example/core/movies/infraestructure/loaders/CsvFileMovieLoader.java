package org.example.core.movies.infraestructure.loaders;

import org.example.core.movies.application.ports.MovieLoader;
import org.example.core.movies.domain.Movie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileMovieLoader implements MovieLoader {

    public CsvFileMovieLoader(String path) {
        this.path = path;
    }

    private final String path;

    @Override
    public List<Movie> load() {
        try(BufferedReader reader = new BufferedReader(new FileReader(this.path))){
           return load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Movie> load(BufferedReader reader) {
        return reader.lines()
                .skip(1)
                .map(this::createMovieFromCsvLine)
                .collect(Collectors.toList());
    }

    private Movie createMovieFromCsvLine(String s) {
        var movieData = s.split(",");
        return new Movie(
                movieData[0],
                movieData[1],
                movieData[2],
                Integer.parseInt(movieData[3]),
                Double.parseDouble(movieData[4])
        );
    }
}
