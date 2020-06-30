package com.clothes.mall.domain.admin;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor
@ToString
public class AdminUpdateDto {

    private Long id;

    private String aid;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    @Builder
    public AdminUpdateDto(Long id, String aid, String password, String name, String email, String phoneNumber){
        this.id = id;
        this.aid = aid;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
