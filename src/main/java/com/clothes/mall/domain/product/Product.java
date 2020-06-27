package com.clothes.mall.domain.product;

import com.clothes.mall.domain.admin.Admin;
import com.clothes.mall.domain.BaseTimeEntity;
import com.clothes.mall.domain.ProductCategoryDetail;
import com.clothes.mall.domain.ProductStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int costPrice;

    @Column
    private int sellingPrice;

    @Column(columnDefinition = "TEXT")
    private String productInformation;

    @Column
    @Enumerated(value = EnumType.STRING)
    private ProductStatus status;

    @OneToOne(fetch = FetchType.LAZY)
    private Admin admin;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductCategoryDetail productCategoryDetail;

    @Column
    private int isDeleted;

    @Builder
    public Product(String name, int costPrice, int sellingPrice, String productInformation, ProductStatus status, Admin admin, ProductCategoryDetail productCategoryDetail){
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productInformation = productInformation;
        this.status = status;
        this.admin = admin;
        this.productCategoryDetail = productCategoryDetail;
    }


}
