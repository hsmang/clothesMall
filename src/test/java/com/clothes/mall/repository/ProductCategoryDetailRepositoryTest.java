package com.clothes.mall.repository;

import com.clothes.mall.domain.category.ProductCategory;
import com.clothes.mall.domain.category.detail.ProductCategoryDetail;
import com.clothes.mall.service.ProductCategoryDetailService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCategoryDetailRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductCategoryDetailRepository productCategoryDetailRepository;
    @Autowired
    private ProductCategoryDetailService productCategoryDetailService;

    @After
    public void tearDown() throws Exception {
        //productCategoryRepository.deleteAll();
    }


    @Test
    public void save_product_category_detail(){
        // given
        ProductCategory productCategory = productCategoryRepository.getOne(1L);

        String name = "긴팔";
        int priority = 0;

        ProductCategoryDetail productCategoryDetail = ProductCategoryDetail.builder()
                .productCategory(productCategory)
                .name(name)
                .priority(priority)
                .build();

        // when
        productCategoryDetailRepository.save(productCategoryDetail);

        // then
        assertThat(productCategoryDetail.getName(), is(name));

    }

    @Test
    public void update_product_category_detail(){
        // given
        ProductCategoryDetail productCategoryDetail = productCategoryDetailRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));

        // when
        String name = "긴팔@@@";
        productCategoryDetailService.changeName(productCategoryDetail.getId(), name);

        // then
        ProductCategoryDetail checkProductCategoryDetail = productCategoryDetailRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));
        assertThat(checkProductCategoryDetail.getName(), is(name));

    }

}
