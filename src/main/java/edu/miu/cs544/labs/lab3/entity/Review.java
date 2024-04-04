package edu.miu.cs544.labs.lab3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {

    @Id
    private Long id;

    private int rating;

    private String comment;

    // ManyToOne with User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ManyToOne with Product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
