package com.clothes.mall.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ProductCategoryDetail extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int priority;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductCategory productCategory;

    @Column
    private int isDeleted;

    @Builder
    public ProductCategoryDetail(String name, int priority, ProductCategory productCategory){
        this.name = name;
        this.priority = priority;
        this.productCategory = productCategory;
    }


}
