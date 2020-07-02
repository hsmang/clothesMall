package com.clothes.mall.domain.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor
@ToString
public class AdminResponseDto {

    private Long id;

    private String aid;

    private String name;

    private String email;

    private String phoneNumber;

    private AdminStatus status;

    private int isDeleted;

    public AdminResponseDto(Admin admin){
        this.id = admin.getId();
        this.aid = admin.getAid();
        this.name = admin.getName();
        this.email = admin.getEmail();
        this.phoneNumber = admin.getPhoneNumber();
        this.status = admin.getStatus();
        this.isDeleted = admin.getIsDeleted();
    }
}
