package com.clothes.mall.domain.admin;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor
@ToString
public class AdminResponseListDto {

    private Long id;

    private String aid;

    private String name;

    private String email;

    private String phoneNumber;

    private AdminStatus status;

    private int isDeleted;

    public AdminResponseListDto(Admin admin){
        this.id = admin.getId();
        this.aid = admin.getAid();
        this.name = admin.getName();
        this.email = admin.getEmail();
        this.phoneNumber = admin.getPhoneNumber();
        this.status = admin.getStatus();
        this.isDeleted = admin.getIsDeleted();
    }
}
