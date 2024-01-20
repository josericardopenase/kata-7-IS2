package org.example.apps.restApi;

public interface Command {
    Output execute(Input input);

    interface Input{
        String get(String key);
    }

    interface Output<Model>{
        int statusCode();
        Model result();
    }

    static <Model>Output<Model> output(Model result, int statusCode){
        return new Output<Model>() {
            @Override
            public int statusCode() {
                return statusCode;
            }

            @Override
            public Model result() {
                return result;
            }
        };
    }
}
