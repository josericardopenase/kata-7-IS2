package org.example.apps.restApi;
import com.google.gson.Gson;
import org.example.apps.restApi.movies.commands.BarChartMoviesCreatorCommand;
import org.example.apps.restApi.movies.commands.FindAllMoviesCommand;
import org.example.core.charts.application.ports.DataLoader;
import org.example.core.charts.infrastructure.loaders.FileDataLoader;
import org.example.core.movies.domain.Movie;
import org.example.core.movies.infrastructure.MovieSerializer;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);
        var gson = new Gson();
        defaultResponseTransformer(gson::toJson);
        path("api/", () -> {
                path("v1/", () -> {
                    path("movies", () -> {
                        get("/chart/", (req, res) -> execute(req, res, new BarChartMoviesCreatorCommand(getMoviesLoader())));
                        get("/", (req, res) -> execute(req, res, new FindAllMoviesCommand(getMoviesLoader())));
                    });
                    path("users", () -> {
                    });
                });
            }
        );
    }

    private static Object execute(Request req, Response res, Command command) {
        return CommandExecutor
                .from(req, res)
                .execute(command)
                .result();
    }
    private static DataLoader<Movie> getMoviesLoader() {
        return new FileDataLoader<Movie>("movies.csv", new MovieSerializer());
    }
}
