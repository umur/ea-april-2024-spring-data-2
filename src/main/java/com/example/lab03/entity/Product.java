package com.example.lab03.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
//@NamedEntityGraph(
//        name = "product-with-reviews-and-user",
//        attributeNodes = {
//                @NamedAttributeNode(value = "reviews", subgraph = "reviews-subgraph")
//        },
//        subgraphs = {
//                @NamedSubgraph(
//                        name = "reviews-subgraph",
//                        attributeNodes = @NamedAttributeNode(value = "user")
//                )
//        }
//)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Double rating;

    @JsonIgnoreProperties("product")
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    //@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Review> reviews = new ArrayList<>();
}
