package com.lkq.lkqcrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.lkq.lkqcrm.mapper")
public class LkqCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(LkqCrmApplication.class, args);
    }

}
