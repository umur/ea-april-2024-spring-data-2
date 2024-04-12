package com.david.lab.model;

public record BenchmarkResponse(String duration,
                                String memory,
                                String numberOfQueries,
                                String dataTransferRate) {
    public BenchmarkResponse(long duration,
                             long memory,
                             long numberOfQueries,
                             double dataTransferRate) {
        this(duration + " ms elapsed.",
                memory / 1024 + " megabytes.",
                numberOfQueries + " SQL queries.",
                dataTransferRate + " bytes/millisec.");
    }
}