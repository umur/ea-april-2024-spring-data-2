package com.david.lab.model.batch;

import com.david.lab.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ReviewBatchEager implements Persistable<Long> {
    @Id
    private long id;
    private String comment;

    @JsonBackReference
    @ManyToOne
    private ProductBatchEager reviewedProduct;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private User submittedUser;

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return id;
    }
}