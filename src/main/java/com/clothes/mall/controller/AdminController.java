package com.clothes.mall.controller;

import com.clothes.mall.domain.admin.Admin;
import com.clothes.mall.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminRepository adminRepository;

    @PostMapping("/api/admin")
    public Admin save(@RequestBody Admin admin){
        return adminRepository.save(admin);
    }

}
