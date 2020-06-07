package com.rad.rduserportal.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableJpaRepositories(
		basePackages = {"com.rad.rdoauth.entity"},
		entityManagerFactoryRef = "oauthEntityManager",
		transactionManagerRef = "oauthTransactionManager"
)
public class RDOauthDataSource {

	@Value("${oauth.spring.datasource.url}")
	private String authUrl;
	
	@Value("${oauth.spring.datasource.username}")
	private String authUsername;
	
	@Value("${oauth.spring.datasource.password}")
	private String authPasswd;
	
	@Value("${oauth.spring.datasource.driverClassName}")
	private String authDriverClassName;
	
	@Value("${oauth.spring.datasource.dialect}")
	private String authDialect;
	
	@Value("${oauth.spring.datasource.show_sql}")
	private String authShowSql;
	
	@Primary
	@Bean(name = "oauthDataSource")
	public DataSource oauthDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(authDriverClassName);
		dataSource.setUrl(authUrl);
		dataSource.setUsername(authUsername);
		dataSource.setPassword(authPasswd);
		return dataSource;
	}
	
	@Bean(name = "oauthJdbcTemplate")
	public JdbcTemplate oauthJdbcTemplate(@Qualifier("oauthDataSource") DataSource oauthDataSource) {
		return new JdbcTemplate(oauthDataSource);
	}
}
