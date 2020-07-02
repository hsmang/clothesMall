package com.clothes.mall.domain.product;

import com.clothes.mall.domain.BaseTimeEntity;
import com.clothes.mall.domain.admin.Admin;
import com.clothes.mall.domain.category.detail.ProductCategoryDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
public class ProductSaveDto {

    private String name;

    private int costPrice;

    private int sellingPrice;

    private String productInformation;

    private Admin admin;

    private ProductCategoryDetail productCategoryDetail;


    @Builder
    public ProductSaveDto(String name, int costPrice, int sellingPrice, String productInformation, Admin admin, ProductCategoryDetail productCategoryDetail){
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productInformation = productInformation;
        this.admin = admin;
        this.productCategoryDetail = productCategoryDetail;
    }

    public Product toEntity(){
        return Product.builder()
                .name(name)
                .costPrice(costPrice)
                .sellingPrice(sellingPrice)
                .productInformation(productInformation)
                .productCategoryDetail(productCategoryDetail)
                .admin(admin)
                .build();
    }
}
