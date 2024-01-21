package org.example.core.movies.infrastructure;

import org.example.core.charts.application.ports.DataLoader;
import org.example.core.movies.domain.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MockMovieLoader implements DataLoader<Movie> {
    @Override
    public List<Movie> load() {
        return load(new ArrayList<>());
    }

    private List<Movie> load(List<Movie> list) {
        IntStream.range(0, 20).forEach(x -> list.add(getRandomMovie(x)));
        return list;
    }

    private Movie getRandomMovie(int x) {
        return new Movie("pepe", getGender(x), "studio", 60 * x, 89.8 * x);
    }

    private String getGender(int x) {
        String[] genres = new String[]{"terror", "diversion", "sorpresa"};
        return genres[x % genres.length];
    }
}
