package org.example.apps.restApi;
import com.google.gson.Gson;
import org.example.apps.restApi.movies.commands.FindAllMoviesCommand;
import org.example.core.charts.application.ports.DataLoader;
import org.example.core.charts.infrastructure.loaders.FileDataLoader;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.infrastructure.MovieSerializer;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);
        var gson = new Gson();
        defaultResponseTransformer(gson::toJson);
        path("api/", () -> {
                    path("movies", () -> {
                        get("/", (req, res) -> CommandExecutor.from(req, res).execute(new FindAllMoviesCommand(getMoviesLoader())).result());

                    });
                    path("users", () -> {

                    });
                }
        );
    }

    private static DataLoader<Movie> getMoviesLoader() {
        return new FileDataLoader<Movie>("movies.csv", new MovieSerializer());
    }
}
