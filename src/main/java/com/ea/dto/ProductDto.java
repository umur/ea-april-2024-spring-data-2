package com.ea.dto;

import com.ea.domain.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long productId;

    private String productName;

    private Double productPrice;

    private List<ReviewDto> reviews;


    public ProductDto(Product product){
        productName = product.getName();
        productId = product.getId();
        productPrice = product.getPrice();
        if(!CollectionUtils.isEmpty(product.getReview())) {
            reviews = product.getReview().stream().map(ReviewDto::new).toList();
        }
    }

}
