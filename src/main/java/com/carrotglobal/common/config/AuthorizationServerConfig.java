package com.carrotglobal.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@EnableAuthorizationServer // OAuth2 인증서버 어노테이션
// OAuth2 인증을 위한 엑세스 토큰, 리퍼레쉬 토큰 발급과 발급된 토큰을 통한 OAuth2 인증 등 핵심기능 활성화
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private TokenStore TokenStore;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()") //url:/oauth/token_key,exposes public key for token verification if using JWT tokens
                .checkTokenAccess("isAuthenticated()") //url:/oauth/check_token allow check token
                .allowFormAuthenticationForClients();
    }

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		//endpoints.tokenStore(TokenStore);
		endpoints.authenticationManager(authenticationManager);
	}
	
	/*
     * Client에 대한 인증 처리를 위한 설정
     * 1) In-Memory 설정 - 기본 구현체 InMemoryClientDetailsService(Map에 클라이언트를 저장)
     * 2) JDBC 설정 - 기본 구현체 JdbcClientDetailsService(JdbcTemplate를 이용한 DB이용)
     * 3) CleintDetailsService 설정
     */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("foo")
			.secret(passwordEncoder.encode("bar"))
			.authorizedGrantTypes(
					"password", "client_credentials") // 엑세스 토큰 발급 가능한 인증 타입 authorization_code, password, client_credentials, implicit, refresh_token
			.scopes("read")
			.accessTokenValiditySeconds(60*60*3); // 3시간 default value 60*60*12 ( 초단위 );
		/*	관리자 인 사용자는 이런식으루 나눠 줘도 될 듯
		 * 나중에 아예 디비에서 관리해주는거로 바꾸기
		.and()
			.withClient("admin")
			.secret("admintest")
			..
			*/
	}
	
}
