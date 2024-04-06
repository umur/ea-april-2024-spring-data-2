package com.Shop.Market.Domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Username;
    private String Email;
    private String PasswordHash;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    public void addReview(Review review) {
        if(CollectionUtils.isEmpty(reviews)){
            this.reviews = new ArrayList<>();
        }
        this.reviews.add(review);
    }
}

