package com.clothes.mall.domain.product;

import com.clothes.mall.domain.admin.Admin;
import com.clothes.mall.domain.category.ProductCategory;
import com.clothes.mall.domain.category.detail.ProductCategoryDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
public class ProductResponseListDto {

    private Long id;
    private String name;

    private int costPrice;

    private int sellingPrice;

    private String productInformation;

    private ProductStatus status;

    private Admin admin;

    private ProductCategoryDetail productCategoryDetail;

    private int isDeleted;


    public ProductResponseListDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.costPrice = product.getCostPrice();
        this.sellingPrice = product.getSellingPrice();
        this.productInformation = product.getProductInformation();
        this.status = product.getStatus();
        this.admin = product.getAdmin();
        this.productCategoryDetail = product.getProductCategoryDetail();
        this.isDeleted = product.getIsDeleted();
    }


}
