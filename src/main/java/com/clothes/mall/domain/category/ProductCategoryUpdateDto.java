package com.clothes.mall.domain.category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCategoryUpdateDto {

    private String name;

    private int priority;

    @Builder
    public ProductCategoryUpdateDto(String name, int priority){
        this.name = name;
        this.priority = priority;
    }

    public ProductCategory toEntity(){
        return ProductCategory.builder()
                .name(name)
                .priority(priority)
                .build();
    }

}
