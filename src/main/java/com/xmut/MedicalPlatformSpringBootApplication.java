package com.xmut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xmut.mapper")
@SpringBootApplication
public class MedicalPlatformSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalPlatformSpringBootApplication.class, args);
    }

}
