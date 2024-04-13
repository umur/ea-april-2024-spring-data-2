package miu.ea.group3g.lab4.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
@Table(name = "review")
public class ReviewSelectLazy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    private ProductSelectLazy product;

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    private User user;

}
