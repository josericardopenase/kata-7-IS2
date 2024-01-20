package org.example.apps.restApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Spark;

public class Main {
    public static void main(String[] args) {
        Spark.port(8080);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Spark.before((req, res) -> gson.toJson(req.body()));
        Spark.get("/hello", (req, res) -> new Response("100"));
        Spark.after((req, res) -> gson.toJson(req.body()));
    }

    public static class Response{
        private final String status;

        public Response(String status) {
            this.status = status;
        }
    }
}
