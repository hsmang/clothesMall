package com.clothes.mall.domain.category;

import com.clothes.mall.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class ProductCategory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int priority;

    @Column
    private int isDeleted;

    @Builder
    public ProductCategory(String name, int priority){
        this.name = name;
        this.priority = priority;
    }

    public void changeName(String name) {
        this.name = name;
    }
}
