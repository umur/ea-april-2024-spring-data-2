package miu.ea.group3g.lab4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
//@NamedEntityGraph(name = "User.reviews", attributeNodes = @NamedAttributeNode("reviews"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //    @BatchSize(size = 50)
//    @JsonManagedReference
//    @OneToMany(mappedBy = "user")
//    @Fetch(FetchMode.JOIN)
//    private List<ReviewBatchLazy> reviews;
}
