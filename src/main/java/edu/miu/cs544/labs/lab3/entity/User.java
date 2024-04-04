package edu.miu.cs544.labs.lab3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}
