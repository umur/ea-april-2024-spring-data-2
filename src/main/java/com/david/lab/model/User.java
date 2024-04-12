package com.david.lab.model;

import com.david.lab.model.select.ReviewSelectLazy;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "submittedUser")
    private List<ReviewSelectLazy> submittedReviewSelectLazies;
}