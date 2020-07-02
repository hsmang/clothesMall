package com.clothes.mall.repository;

import com.clothes.mall.domain.category.detail.ProductCategoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryDetailRepository extends JpaRepository<ProductCategoryDetail, Long> {
}
