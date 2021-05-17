package com.formacionbdi.spring.app.zuul.oauth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope
@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	@Value("${config.security.oauth.jwt.key}")
	private String key;
	

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/security/oauth/**").permitAll()
		.antMatchers(HttpMethod.GET, "/api/products/list/", "/api/items/list/", "/api/users/users").permitAll()
		.antMatchers(HttpMethod.GET, "/api/products/detail/{id}", "/api/item/detail/{id}/quantity/{quantity", 
				"/api/users/users/{id}").hasAnyRole("ADMIN", "USER")
//		.antMatchers(HttpMethod.POST, "/api/products/create", "/api/users/users").hasRole("ADMIN")
//		.antMatchers(HttpMethod.PUT, "/api/products/update/{id}", "/api/users/users/{id}").hasRole("ADMIN")
//		.antMatchers(HttpMethod.DELETE, "/api/products/delete/{id}", "/api/users/users/{id}").hasRole("ADMIN");
		.antMatchers("/api/products/**", "/api/users/users/**").hasRole("ADMIN")
		.anyRequest().authenticated();
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(key);
		return jwtAccessTokenConverter;
	}
}
