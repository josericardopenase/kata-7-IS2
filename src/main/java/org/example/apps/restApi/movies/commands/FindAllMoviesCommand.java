package org.example.apps.restApi.movies.commands;

import org.example.apps.restApi.Command;
import org.example.core.charts.application.ports.DataLoader;
import org.example.core.movies.domain.Movie;

public class FindAllMoviesCommand implements Command {

    private final DataLoader<Movie> loader;

    public FindAllMoviesCommand(DataLoader<Movie> loader) {
        this.loader = loader;
    }

    @Override
    public Output execute(Input input) {
        return Command.output(loader.load(), 200);
    }
}
