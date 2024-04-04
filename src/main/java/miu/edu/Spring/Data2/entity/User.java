package miu.edu.Spring.Data2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Review> reviews;
}
