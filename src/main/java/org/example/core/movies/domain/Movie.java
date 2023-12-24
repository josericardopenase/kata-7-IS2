package org.example.core.movies.domain;

public record Movie(
        String name,
        String genre,
        String studio,
        int audienceScore,
        double profitability
) {
}
