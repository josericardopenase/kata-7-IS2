package org.example.apps.restApi;
import com.google.gson.Gson;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);
        var gson = new Gson();
        defaultResponseTransformer(gson::toJson);
    }
}
