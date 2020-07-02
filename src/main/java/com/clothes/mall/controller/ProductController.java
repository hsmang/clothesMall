package com.clothes.mall.controller;

import com.clothes.mall.domain.product.ProductResponseDto;
import com.clothes.mall.domain.product.ProductResponseListDto;
import com.clothes.mall.domain.product.ProductSaveDto;
import com.clothes.mall.domain.product.ProductUpdateDto;
import com.clothes.mall.domain.response.CommonResult;
import com.clothes.mall.domain.response.ListResult;
import com.clothes.mall.domain.response.SingleResult;
import com.clothes.mall.service.ProductService;
import com.clothes.mall.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ResponseService responseService;
    private final ProductService productService;

    @PostMapping("/api/products")
    public CommonResult save(@RequestBody ProductSaveDto productSaveDto){
        productService.save(productSaveDto);
        return responseService.getSuccessResult();
    }

    @PutMapping("/api/products/{id}")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody ProductUpdateDto productUpdateDto){
        productService.update(id, productUpdateDto);
        return responseService.getSuccessResult();
    }

    @GetMapping("/api/products")
    public ListResult<ProductResponseListDto> list(@PageableDefault Pageable pageable){
        return responseService.getListResult(productService.list(pageable));
    }

    @GetMapping("/api/products/{id}")
    public SingleResult<ProductResponseDto> select(@PathVariable Long id){
        return responseService.getSingleResult(productService.findById(id));
    }

    @DeleteMapping("/api/products/{id}")
    public CommonResult delete(@PathVariable("id") Long id){
        productService.delete(id);
        return responseService.getSuccessResult();
    }
}
