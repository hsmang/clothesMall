package com.clothes.mall.domain.product;

public enum ProductStatus {
    active("활동중"),
    nonActive("비활성");

    private String value;

    ProductStatus(String value) { this.value = value; }
    public String getValue() { return this.value; }
}
