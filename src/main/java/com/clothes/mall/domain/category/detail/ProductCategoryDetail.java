package com.clothes.mall.domain.category.detail;

import com.clothes.mall.domain.BaseTimeEntity;
import com.clothes.mall.domain.category.ProductCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Entity
@DynamicUpdate // 변경한 필드만 대응
public class ProductCategoryDetail extends BaseTimeEntity {

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


    public void changeName(String name) {
        this.name = name;
    }

    /**
     * 수정
     * @param productCategoryDetailUpdateDto
     */
    public void update(ProductCategoryDetailUpdateDto productCategoryDetailUpdateDto) {
        this.productCategory = productCategoryDetailUpdateDto.getProductCategory();
        this.name = productCategoryDetailUpdateDto.getName();
        this.priority = productCategoryDetailUpdateDto.getPriority();
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
