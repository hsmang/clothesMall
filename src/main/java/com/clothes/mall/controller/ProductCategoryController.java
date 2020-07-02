package com.clothes.mall.controller;

import com.clothes.mall.domain.admin.AdminResponseDto;
import com.clothes.mall.domain.admin.AdminResponseListDto;
import com.clothes.mall.domain.admin.AdminSaveDto;
import com.clothes.mall.domain.admin.AdminUpdateDto;
import com.clothes.mall.domain.category.ProductCategoryResponseDto;
import com.clothes.mall.domain.category.ProductCategoryResponseListDto;
import com.clothes.mall.domain.category.ProductCategorySaveDto;
import com.clothes.mall.domain.category.ProductCategoryUpdateDto;
import com.clothes.mall.domain.response.CommonResult;
import com.clothes.mall.domain.response.ListResult;
import com.clothes.mall.domain.response.SingleResult;
import com.clothes.mall.service.AdminService;
import com.clothes.mall.service.ProductCategoryDetailService;
import com.clothes.mall.service.ProductCategoryService;
import com.clothes.mall.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class ProductCategoryController {
    private final ResponseService responseService;
    private final ProductCategoryService productCategoryService;

    @PostMapping("/api/categories")
    public CommonResult save(@RequestBody ProductCategorySaveDto productCategorySaveDto){
        productCategoryService.save(productCategorySaveDto);
        return responseService.getSuccessResult();
    }

    @PutMapping("/api/categories/{id}")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody ProductCategoryUpdateDto productCategoryUpdateDto){
        System.out.println(productCategoryUpdateDto);
        productCategoryService.update(id, productCategoryUpdateDto);
        return responseService.getSuccessResult();
    }

    @GetMapping("/api/categories")
    public ListResult<ProductCategoryResponseListDto> list(@PageableDefault Pageable pageable){
        return responseService.getListResult(productCategoryService.list(pageable));
    }

    @GetMapping("/api/categories/{id}")
    public SingleResult<ProductCategoryResponseDto> select(@PathVariable Long id){
        return responseService.getSingleResult(productCategoryService.findById(id));
    }

    @DeleteMapping("/api/categories/{id}")
    public CommonResult delete(@PathVariable("id") Long id){
        productCategoryService.delete(id);
        return responseService.getSuccessResult();
    }
}
