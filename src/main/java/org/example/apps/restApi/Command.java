package org.example.apps.restApi;

public interface Command {
    interface Input{
        String get(String key);
    }

    interface Output<Model>{
       int statusCode();
       Model result();
    }
}
