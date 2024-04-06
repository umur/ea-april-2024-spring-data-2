package com.Shop.Market.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

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
