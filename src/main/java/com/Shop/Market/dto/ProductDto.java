package com.Shop.Market.dto;

import com.Shop.Market.Domain.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDto {

    private String productName;

    private Long productId;

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
