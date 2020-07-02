package com.clothes.mall.service;

import com.clothes.mall.domain.admin.*;
import com.clothes.mall.domain.product.*;
import com.clothes.mall.repository.AdminRepository;
import com.clothes.mall.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;


    /**
     * Product 등록
     * @param productSaveDto
     */
    public void save(ProductSaveDto productSaveDto){
        productRepository.save(productSaveDto.toEntity());
    }


    /**
     * Product 수정
     * @param productUpdateDto
     */
    @Transactional
    public void update(Long id, ProductUpdateDto productUpdateDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다.") );

        product.update(productUpdateDto);
    }

    /**
     * Product 리스트
     * @param pageable
     * @return
     */
    public List<ProductResponseListDto> list(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return productRepository.findAll(pageable).stream().map(ProductResponseListDto::new).collect(Collectors.toList());
    }


    /**
     * Product 삭제
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));

        product.delete(true);

    }

    /**
     * Product 한 건 가져오기
     * @param id
     * @return
     */
    public ProductResponseDto findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));
        ProductResponseDto productResponseDto = new ProductResponseDto(product);
        return productResponseDto;
    }
}
