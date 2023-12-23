package org.example.core.movies.domain;

public record Movie (
        String name,
        String genre,
        int audienceScore,
        double profitability
){
}
