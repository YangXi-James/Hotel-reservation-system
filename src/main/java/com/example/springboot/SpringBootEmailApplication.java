package com.example.springboot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

@MapperScan(basePackages = {"com.example.springboot.mapper","com.example.springboot.mapper.Extends"})

@EnableScheduling
@EnableAsync

public class SpringBootEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmailApplication.class, args);
    }

}
