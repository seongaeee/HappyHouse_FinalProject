package com.happyhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.happyhouse.dao"})
public class HappyHouseSpringFrameworkTeam9Application {

	public static void main(String[] args) {
		SpringApplication.run(HappyHouseSpringFrameworkTeam9Application.class, args);
	}

}
