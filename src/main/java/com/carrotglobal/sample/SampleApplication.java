package com.carrotglobal.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={ DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class})
// Spring Boot�뿉�꽌 mybatis �궗�슜�븯湲� �쐞�빐 DataSource�뿉 ���븳 援ы쁽泥대�� 吏곸젒�벑濡앺빐�빞 �븯誘�濡� DataSource 諛� TransactionManager�뿉 ���븳 �옄�룞�꽕�젙�쓣 �젣�쇅�븳�떎.
@ComponentScan(basePackages= {"com.carrotglobal"}) // basePackage瑜� �젙�빐以섏꽌 �뼱�끂�뀒�씠�뀡 �뒪罹뷀븯�룄濡� �꽕�젙
public class SampleApplication {
// 二쇱꽍 
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
