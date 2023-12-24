package org.example.core.users.infrastructure;

import org.example.core.charts.application.ports.ModelSerializer;
import org.example.core.users.domain.User;

public class UserCsvSerializer implements ModelSerializer<User> {
    @Override
    public User serialize(String data) {
        var splittedData = data.split(",");
        return new User(
                splittedData[0],
                splittedData[1],
                splittedData[2],
                splittedData[3]
        );
    }
}
