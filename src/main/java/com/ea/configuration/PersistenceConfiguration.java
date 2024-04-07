package com.ea.configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

    @PersistenceContext
    private EntityManager entityManager;
}
