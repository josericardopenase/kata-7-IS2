package org.example.apps.restApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        defaultResponseTransformer(gson::toJson);
        before((req, res) -> res.type("application/json"));
        get("/chart", (req, res) -> new Response("300"));
    }

    public static class Response{
        private final String status;

        public Response(String status) {
            this.status = status;
        }
    }
}
