package miu.edu.Spring.Data2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Product {

    @Id
    private Long id;
    private String name;
    private double price;
    private double rating;

    @JsonManagedReference

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Review> reviews;
}
