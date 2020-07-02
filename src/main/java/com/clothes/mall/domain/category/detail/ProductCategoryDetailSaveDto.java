package com.clothes.mall.domain.category.detail;

import com.clothes.mall.domain.category.ProductCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCategoryDetailSaveDto {

    private ProductCategory productCategory;

    private String name;

    private int priority;

    @Builder
    public ProductCategoryDetailSaveDto(ProductCategory productCategory, String name, int priority){
        this.productCategory = productCategory;
        this.name = name;
        this.priority = priority;
    }

    public ProductCategoryDetail toEntity(){
        return ProductCategoryDetail.builder()
                .productCategory(productCategory)
                .name(name)
                .priority(priority)
                .build();
    }

}
