package com.david.lab.product.model;

public record BenchmarkResponse(String duration,
                                String memory,
                                String numberOfQueries,
                                String dataTransferRate) {
}