package org.example.core.users.infrastructure;

import org.example.core.charts.application.ports.ModelSerializer;
import org.example.core.users.domain.User;

public class CsvUserSerializer implements ModelSerializer<User> {

    @Override
    public User serialize(Input data) {
        return new User(
                data.get(0),
                data.get(1),
                data.get(2),
                data.get(3)
        );
    }
}
