package com.ea.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private User user;

    @ManyToOne
    @JoinColumn
    private Product product;
}
