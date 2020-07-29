package com.clothes.mall.repository;

import com.clothes.mall.domain.admin.Admin;
import com.clothes.mall.domain.admin.AdminResponseListDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findAllByIsDeleted(int isDeleted, Pageable pageable);
}
