package com.clothes.mall.domain.category.detail;

import com.clothes.mall.domain.category.ProductCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCategoryDetailResponseDto {

    private Long id;

    private ProductCategory productCategory;

    private String name;

    private int priority;

    private int isDeleted;

    public ProductCategoryDetailResponseDto(ProductCategoryDetail productCategoryDetail){
        this.id = productCategoryDetail.getId();
        this.productCategory = productCategoryDetail.getProductCategory();
        this.name = productCategoryDetail.getName();
        this.priority = productCategoryDetail.getPriority();
        this.isDeleted = productCategoryDetail.getIsDeleted();
    }

}
