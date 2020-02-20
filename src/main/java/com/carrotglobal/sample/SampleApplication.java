package com.carrotglobal.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.carrotglobal"}) // basePackage를 정해줘서 어노테이션 스캔하도록 설정
public class SampleApplication {
// 주석
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
