package com.carrotglobal.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer // OAuth2 의 인증을 받아야하는 기능이라고 정의 해주는 어노테이션
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/rest/**")
		.and()
		.authorizeRequests()
		.antMatchers("/rest/**")
		.authenticated();
	}
}
