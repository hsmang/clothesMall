package com.clothes.mall.repository;

import com.clothes.mall.domain.admin.Admin;
import com.clothes.mall.domain.admin.AdminStatus;
import com.clothes.mall.repository.AdminRepository;
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
public class AdminRepositoryTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AdminRepository adminRepository;

    @After
    public void tearDown() throws Exception {
        //adminRepository.deleteAll();
    }

    @Test
    public void save_post_test(){
        // given
        String aid = "aid";
        String password = "password";
        String name = "관리자";
        String email = "aaa@aaa.com";
        String phoneNumber = "010-1234-5678";

        Admin admin = Admin.builder()
                .aid(aid)
                .password(password)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .status(AdminStatus.active)
                .build();

        // when
        Admin saveAdmin = adminRepository.save(admin);

        // then
        assertThat(saveAdmin.getAid(), is(aid));

    }

}
