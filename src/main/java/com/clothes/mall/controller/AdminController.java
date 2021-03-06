package com.clothes.mall.controller;

import com.clothes.mall.domain.admin.AdminResponseDto;
import com.clothes.mall.domain.admin.AdminResponseListDto;
import com.clothes.mall.domain.admin.AdminSaveDto;
import com.clothes.mall.domain.admin.AdminUpdateDto;
import com.clothes.mall.domain.response.CommonResult;
import com.clothes.mall.domain.response.ListResult;
import com.clothes.mall.domain.response.SingleResult;
import com.clothes.mall.repository.AdminRepository;
import com.clothes.mall.service.AdminService;
import com.clothes.mall.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class AdminController {
    private final ResponseService responseService;
    private final AdminService adminService;

    @PostMapping("/api/admins")
    public CommonResult save(@RequestBody AdminSaveDto adminSaveDto){
        adminService.save(adminSaveDto);
        return responseService.getSuccessResult();
    }

    @PutMapping("/api/admins/{id}")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody AdminUpdateDto adminUpdateDto){
        System.out.println(adminUpdateDto);
        adminService.update(id, adminUpdateDto);
        return responseService.getSuccessResult();
    }

    @GetMapping("/api/admins")
    public ListResult<AdminResponseListDto> list(@PageableDefault Pageable pageable){
        return responseService.getListResult(adminService.list(pageable));
    }

    @GetMapping("/api/admins/{id}")
    public SingleResult<AdminResponseDto> select(@PathVariable Long id){
        return responseService.getSingleResult(adminService.findById(id));
    }

    @DeleteMapping("/api/admins/{id}")
    public CommonResult delete(@PathVariable("id") Long id){
        adminService.delete(id);
        return responseService.getSuccessResult();
    }

}
