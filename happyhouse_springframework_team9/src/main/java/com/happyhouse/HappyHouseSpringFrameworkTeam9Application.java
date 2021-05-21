package com.happyhouse;

import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.happyhouse.inteceptor.JwtInterceptor;

@SpringBootApplication
@MapperScan(basePackages = {"com.happyhouse.dao"})
public class HappyHouseSpringFrameworkTeam9Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(HappyHouseSpringFrameworkTeam9Application.class, args);
	}

	@Autowired
    private JwtInterceptor jwtInterceptor;
	
	//JWTInterceptor를 설치
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/api/**") // 기본 적용 경로
                .excludePathPatterns(Arrays.asList("/api/user/**"));// 적용 제외 경로
    }

    //Interceptor를 이용해서 처리하므로 전역의 Corss Origin 처리
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("jwt-auth-token");
    }
}
