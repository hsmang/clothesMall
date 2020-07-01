package com.clothes.mall.service;

import com.clothes.mall.domain.admin.Admin;
import com.clothes.mall.domain.admin.AdminResponseListDto;
import com.clothes.mall.domain.admin.AdminSaveDto;
import com.clothes.mall.domain.admin.AdminUpdateDto;
import com.clothes.mall.domain.category.ProductCategory;
import com.clothes.mall.domain.category.ProductCategoryResponseListDto;
import com.clothes.mall.domain.category.ProductCategorySaveDto;
import com.clothes.mall.domain.category.ProductCategoryUpdateDto;
import com.clothes.mall.repository.AdminRepository;
import com.clothes.mall.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;


    /**
     * ProductCategory 등록
     * @param productCategorySaveDto
     */
    public void save(ProductCategorySaveDto productCategorySaveDto){
        productCategoryRepository.save(productCategorySaveDto.toEntity());
    }


    /**
     * ProductCategory 수정
     * @param productCategoryUpdateDto
     */
    @Transactional
    public void update(Long id, ProductCategoryUpdateDto productCategoryUpdateDto) {
        ProductCategory productCategory = productCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다.") );

        productCategory.update(productCategoryUpdateDto);
    }

    /**
     * ProductCategory 리스트
     * @param pageable
     * @return
     */
    public List<ProductCategoryResponseListDto> list(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return productCategoryRepository.findAll(pageable).stream().map(ProductCategoryResponseListDto::new).collect(Collectors.toList());
    }


    /**
     * ProductCategory 삭제
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));

        productCategory.delete(true);

    }
}
