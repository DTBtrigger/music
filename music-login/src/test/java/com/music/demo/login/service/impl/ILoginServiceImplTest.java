package com.music.demo.login.service.impl;

import com.music.demo.domain.entity.User;
import com.music.demo.login.service.IRegistryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
@Slf4j
class ILoginServiceImplTest {

    @Autowired
    private IRegistryService iRegistryService;

    @Test
    void Registry() {
        User user = User.builder()
                .username("zhang")
                .password("12345")
                .name("张三")
                .phone("12345612345")
                .avatar("jsdfj")
                .email("2732873@jsa.com")
                .build();
        iRegistryService.registry(user);
    }

    @Test
    void rand() {

        for (int i = 0; i < 10; i++ ){
            Random random = new Random();
            int code = random.nextInt(90000 + 10000);
            log.debug("$$$$$$$$$-----{}",code);
        }



    }
}