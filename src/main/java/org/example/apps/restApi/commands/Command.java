package org.example.apps.restApi.commands;

public interface Command {
    Output execute(Input input);

    interface Input{}

    interface Output{}
}
