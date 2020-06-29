package com.clothes.mall.service;

import com.clothes.mall.domain.category.ProductCategoryDetail;
import com.clothes.mall.repository.ProductCategoryDetailRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductCategoryDetailService {

    private final ProductCategoryDetailRepository productCategoryDetailRepository;

    @Transactional
    public void changeName(Long id, String name){
        ProductCategoryDetail productCategoryDetail = productCategoryDetailRepository.getOne(id);
        productCategoryDetail.changeName(name);
    }

}
