package com.liuwohe.communitymis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liuwohe.communitymis.mapper")
public class CommunityMisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityMisApplication.class, args);
    }

}
