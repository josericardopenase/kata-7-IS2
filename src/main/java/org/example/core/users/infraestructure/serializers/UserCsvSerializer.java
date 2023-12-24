package org.example.core.users.infraestructure.serializers;

import org.example.core.shared.application.ports.Serializer;
import org.example.core.users.domain.User;


public class UserCsvSerializer implements Serializer<User> {

    @Override
    public User serialize(String sourceData) {
        var splittedData = sourceData.split(",");
        return new User(
               splittedData[0],
                splittedData[1],
                splittedData[2],
                splittedData[3]

        );
    }
}
