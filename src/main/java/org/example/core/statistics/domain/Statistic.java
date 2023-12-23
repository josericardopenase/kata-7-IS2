package org.example.core.statistics.domain;

public record Statistic<T> (
    T data
){}