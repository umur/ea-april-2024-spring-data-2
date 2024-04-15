package spring.data.lab3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@NamedEntityGraph(name = "Product.reviews", attributeNodes = @NamedAttributeNode("reviews"))
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    // fetch strategy: LAZY and Subselect
//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    @Fetch(FetchMode.SUBSELECT)
//    private List<Review> reviews;

    // fetch strategy: EAGER and Subselect
//    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
//    @JsonManagedReference
//    @Fetch(FetchMode.SUBSELECT)
//    private List<Review> reviews;


    // fetch strategy: EAGER and BATCH
//    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
//    @JsonManagedReference
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 100)
//    private List<Review> reviews;

//    // fetch strategy: LAZY and BATCH
//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 100)
//    private List<Review> reviews;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private List<Review> reviews;

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SELECT)
//    @JsonManagedReference
//    private List<Review> reviews;
}
