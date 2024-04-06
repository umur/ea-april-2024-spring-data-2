package com.Shop.Market.Domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private int rating;

    @Fetch(value = FetchMode.SUBSELECT)
    //@BatchSize(size = 20)
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Review> review;

}
