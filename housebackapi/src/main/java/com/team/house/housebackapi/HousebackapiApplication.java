package com.team.house.housebackapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//扫描mapper
@MapperScan("com.team.house.housebackapi.mapper")
//扫描过滤器
@ServletComponentScan(basePackages = "com.team.house.housebackapi.filter")
public class HousebackapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousebackapiApplication.class, args);
    }

}
