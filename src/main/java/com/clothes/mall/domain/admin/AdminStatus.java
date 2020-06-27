package com.clothes.mall.domain.admin;

public enum AdminStatus {
    active("활동중"),
    nonActive("비활성");

    private String value;

    AdminStatus(String value) { this.value = value; }
    public String getValue() { return this.value; }
}
