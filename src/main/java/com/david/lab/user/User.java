package com.david.lab.user;

import com.david.lab.review.model.ReviewSelect;
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
    private List<ReviewSelect> submittedReviewSelects;
}