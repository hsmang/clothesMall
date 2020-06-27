package com.clothes.mall.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ProductCategory extends BaseTimeEntity{

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

}
