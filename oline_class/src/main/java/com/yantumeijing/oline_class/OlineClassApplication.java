package com.yantumeijing.oline_class;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yantumeijing.oline_class.mapper")
public class OlineClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlineClassApplication.class, args);
	}

}
