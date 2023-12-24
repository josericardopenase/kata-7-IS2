package org.example.core.users.domain;

public record User(
        String username,
        String firstName,
        String lastName,
        String password
) {
}
