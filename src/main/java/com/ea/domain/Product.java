package com.ea.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;


@Data
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private int rating;

    @BatchSize(size = 10)
//    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Review> review;

}
