package org.example.apps.restApi;

import spark.Request;
import spark.Response;

public record CommandExecutor(Request req, Response res) {
    public Command.Output execute(Command command){
        res.type("application/json");
        var execution = command.execute(getInput());
        res.status(execution.statusCode());
       return execution;
    }

    private Command.Input getInput() {
        return new Command.Input() {
            @Override
            public String get(String key) {
                return req.queryParams(key);
            }
        };
    }

    public static CommandExecutor from(Request req, Response res){
        return new CommandExecutor(req, res);
    }

}