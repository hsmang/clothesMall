package com.clothes.mall.domain.admin;

import com.clothes.mall.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Entity
public class Admin extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String aid;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @LastModifiedDate
    private LocalDateTime lastLoginDate;

    @Column
    @Enumerated(EnumType.STRING)
    private AdminStatus status;

    @Column
    private int isDeleted;

    @Builder
    public Admin(String aid, String password, String name, String email, String phoneNumber, AdminStatus status){
        this.aid = aid;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }


}
