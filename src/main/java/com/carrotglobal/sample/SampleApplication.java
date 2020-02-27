package com.carrotglobal.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={ DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class})
//Spring Boot에서 mybatis 사용하기 위해 DataSource에 대한 구현체를 직접등록해야 하므로 DataSource 및 TransactionManager에 대한 자동설정을 제외한다.
@ComponentScan(basePackages= {"com.carrotglobal"}) // basePackage를 정해줘서 어노테이션 스캔하도록 설정
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
