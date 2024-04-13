package miu.ea.group3g.lab4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NamedEntityGraph(name = "Product.reviews", attributeNodes = @NamedAttributeNode("reviews"))
@Table(name = "product")
public class ProductJoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    @Fetch(value = FetchMode.JOIN)
    private List<ReviewJoin> reviews;
}

