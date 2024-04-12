package com.david.lab.model.join;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraph(
        name = "ProductJoinEager.review",
        attributeNodes = @NamedAttributeNode("reviewedProduct"))
public class ProductJoinEager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private BigDecimal price;
    private String rating;

    @JsonManagedReference
    @OneToMany(mappedBy = "reviewedProduct", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<ReviewJoinEager> reviewedProduct;
}
