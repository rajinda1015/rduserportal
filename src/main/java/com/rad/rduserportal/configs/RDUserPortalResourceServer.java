package com.rad.rduserportal.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableResourceServer
public class RDUserPortalResourceServer extends ResourceServerConfigurerAdapter {

	@Value("${resource.server.userportal}")
	private String resource_id;
	
	@Autowired
	private ResourceServerTokenServices tokenService;
	
	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer rssConfigure) {
		rssConfigure
				.resourceId(resource_id).stateless(false)
				.tokenServices(tokenService);
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
					.anonymous().disable()
					.authorizeRequests()
					.antMatchers("/userportal/admin/**").access("hasRole('ADMIN')")
					.antMatchers("/userportal/user/**").access("hasRole('USER')")
					.antMatchers("/userportal/user/**").access("hasRole('ADMIN')")
					.antMatchers("/visit/**").access("hasRole('VISITOR')")
					.antMatchers("/visit/**").access("hasRole('USER')")
					.antMatchers("/visit/**").access("hasRole('ADMIN')")
					.and()
					.exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
}
