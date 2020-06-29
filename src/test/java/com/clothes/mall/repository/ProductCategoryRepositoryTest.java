package com.clothes.mall.repository;

import com.clothes.mall.domain.admin.Admin;
import com.clothes.mall.domain.admin.AdminStatus;
import com.clothes.mall.domain.category.ProductCategory;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCategoryRepositoryTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @After
    public void tearDown() throws Exception {
        //productCategoryRepository.deleteAll();
    }


    @Test
    public void save_product_category(){
        // given
        String name = "상의";
        int priority = 0;

        ProductCategory productCategory = ProductCategory.builder()
                .name(name)
                .priority(priority)
                .build();

        // when
        ProductCategory saveProductCategory = productCategoryRepository.save(productCategory);


        // then
        assertThat(saveProductCategory.getName(), is(name));

    }

}
