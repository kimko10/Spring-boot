package com.carrotglobal.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// 스프링 시큐리티 사용자 인증 처리하는곳. DB로 사용자를 관리하려면 여기를 수정해줘야함.
	//The WebSecurityConfigurerAdapter does not intercept resources that oauth wants to open.

	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.requestMatchers().antMatchers("/oauth/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated();
    }
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("testuser").password("{noop}" + "1234").authorities("USER").build());
		return manager;
	}
	
	// grant type password를 쓰려면 있어야됨
	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

	// 비밀번호 인코더
	@Bean
	public PasswordEncoder encoder() { 
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	// oAuth2.0 Token 저장하고 확인하는곳. 만약 Token을 생성하고 인증하는부분을 DB로 처리한다면 여기를 수정해줘야함. 
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
}
