package com.clothes.mall.service;

import com.clothes.mall.domain.category.detail.*;
import com.clothes.mall.repository.ProductCategoryDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductCategoryDetailService {


    private final ProductCategoryDetailRepository productCategoryDetailRepository;


    /**
     * ProductCategoryDetail 등록
     * @param productCategoryDetailSaveDto
     */
    public void save(ProductCategoryDetailSaveDto productCategoryDetailSaveDto){
        productCategoryDetailRepository.save(productCategoryDetailSaveDto.toEntity());
    }


    /**
     * ProductCategoryDetail 수정
     * @param productCategoryDetailUpdateDto
     */
    @org.springframework.transaction.annotation.Transactional
    public void update(Long id, ProductCategoryDetailUpdateDto productCategoryDetailUpdateDto) {
        ProductCategoryDetail productCategoryDetail = productCategoryDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다.") );

        productCategoryDetail.update(productCategoryDetailUpdateDto);
    }

    /**
     * ProductCategoryDetail 리스트
     * @param pageable
     * @return
     */
    public List<ProductCategoryDetailResponseListDto> list(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return productCategoryDetailRepository.findAll(pageable).stream().map(ProductCategoryDetailResponseListDto::new).collect(Collectors.toList());
    }


    /**
     * ProductCategoryDetail 삭제
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        ProductCategoryDetail productCategoryDetail = productCategoryDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));

        productCategoryDetail.delete(true);

    }

    /**
     * ProductCategoryDetail 한 건 가져오기
     * @param id
     * @return
     */
    public ProductCategoryDetailResponseDto findById(Long id) {
        ProductCategoryDetail productCategoryDetail = productCategoryDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));
        ProductCategoryDetailResponseDto productCategoryDetailResponseDto = new ProductCategoryDetailResponseDto(productCategoryDetail);
        return productCategoryDetailResponseDto;
    }
}
