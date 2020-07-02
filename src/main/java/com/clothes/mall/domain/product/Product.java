package com.clothes.mall.domain.product;

import com.clothes.mall.domain.admin.Admin;
import com.clothes.mall.domain.BaseTimeEntity;
import com.clothes.mall.domain.category.detail.ProductCategoryDetail;
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


    /**
     * 수정
     * @param productUpdateDto
     */
    public void update(ProductUpdateDto productUpdateDto) {
        this.name = productUpdateDto.getName();
        this.costPrice = productUpdateDto.getCostPrice();
        this.sellingPrice = productUpdateDto.getSellingPrice();
        this.productInformation = productUpdateDto.getProductInformation();
        this.status = productUpdateDto.getStatus();
        this.admin = productUpdateDto.getAdmin();
        this.productCategoryDetail = productUpdateDto.getProductCategoryDetail();
    }

    /**
     * 삭제
     * @param b
     */
    public void delete(boolean b) {
        if(b){
            this.isDeleted = 10;
        }
    }
}
