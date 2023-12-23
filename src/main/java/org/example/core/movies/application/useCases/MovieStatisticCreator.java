package org.example.core.movies.application.useCases;

import org.example.core.movies.application.ports.MovieLoader;
import org.example.core.movies.application.ports.MovieStatisticProcessor;
import org.example.core.movies.domain.Statistic;

public class MovieStatisticCreator<T> {

    private final MovieLoader loader;
    private final MovieStatisticProcessor<T> processor;

    public MovieStatisticCreator(MovieLoader loader, MovieStatisticProcessor<T> processor) {
        this.loader = loader;
        this.processor = processor;
    }

    public Statistic<T> create(){
        var movies = this.loader.load();
        return this.processor.process(movies);
    }
}
