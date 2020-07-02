package com.clothes.mall.domain.product;

import com.clothes.mall.domain.admin.Admin;
import com.clothes.mall.domain.category.detail.ProductCategoryDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUpdateDto {

    private Long id;

    private String name;

    private int costPrice;

    private int sellingPrice;

    private String productInformation;

    private ProductStatus status;

    private Admin admin;

    private ProductCategoryDetail productCategoryDetail;


    @Builder
    public ProductUpdateDto(Long id, String name, int costPrice, int sellingPrice, String productInformation, ProductStatus status, Admin admin, ProductCategoryDetail productCategoryDetail){
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productInformation = productInformation;
        this.status = status;
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
