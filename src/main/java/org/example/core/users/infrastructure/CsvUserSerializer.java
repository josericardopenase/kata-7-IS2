package org.example.core.users.infrastructure;

import org.example.core.charts.application.ports.ModelSerializer;
import org.example.core.users.domain.User;

public class CsvUserSerializer implements ModelSerializer<User> {
    @Override
    public User serialize(String data) {
        return serialize(data.split(","));
    }

    private User serialize(String[] split) {
        return new User(
                split[0],
                split[1],
                split[2],
                split[3]
        );
    }
}
