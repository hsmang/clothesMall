package com.clothes.mall.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCategoryResponseDto {

    private Long id;

    private String name;

    private int priority;

    private int isDeleted;

    public ProductCategoryResponseDto(ProductCategory productCategory){
        this.id = productCategory.getId();
        this.name = productCategory.getName();
        this.priority = productCategory.getPriority();
        this.isDeleted = productCategory.getIsDeleted();
    }

    public ProductCategory toEntity(){
        return ProductCategory.builder()
                .name(name)
                .priority(priority)
                .build();
    }

}
