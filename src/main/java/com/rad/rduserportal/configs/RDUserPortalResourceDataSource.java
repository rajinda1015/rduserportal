package com.rad.rduserportal.configs;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Resource database
 * 
 * @author rajinda
 * @since 04th May 2020
 * @version 1.0
 */
@Configuration
public class RDUserPortalResourceDataSource {

	@Value("${resource.datasource.url}")
	private String resourceUrl;
	
	@Value("${resource.datasource.username}")
	private String resourceUsername;
		
	@Value("${resource.datasource.password}")
	private String resourcePasswd;
	
	@Value("${resource.datasource.deriverClassName}")
	private String resourceDriverClassName;
	
	@Value("${resource.datasource.dialect}")
	private String dialect;
	
	@Value("${resource.datasource.show_sql}")
	private String showSql;
	
	@Bean(name = "resourceDataSource")
	public DataSource resourceDataSource() {
		DriverManagerDataSource resourceDataSource = new DriverManagerDataSource();
		resourceDataSource.setUrl(resourceUrl);
		resourceDataSource.setUsername(resourceUsername);
		resourceDataSource.setPassword(resourcePasswd);
		resourceDataSource.setDriverClassName(resourceDriverClassName);
		return resourceDataSource;
	}
	
	@Bean(name = "userPortalEntityManager")
	public LocalContainerEntityManagerFactoryBean userPortalEntityManager() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(resourceDataSource());
		entityManager.setPackagesToScan("com.rad.rduserportal.dao.entity");
		entityManager.setPersistenceUnitName("oauthEntityManager");
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		entityManager.setJpaVendorAdapter(adapter);
		
		HashMap<String, Object> hbProperties = new HashMap<String, Object>();
		hbProperties.put("hibernate.dialect", dialect);
		hbProperties.put("hibernate.show_sql", showSql);
		entityManager.setJpaPropertyMap(hbProperties);
		return entityManager;
	}
	
	@Bean(name = "userPortalTransactionManager")
	public PlatformTransactionManager userPortalTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(userPortalEntityManager().getObject());
		return transactionManager;
	}
	
	@Bean(name = "resourceJdbcTemplate")
	public JdbcTemplate resourceJdbcTemplate(@Qualifier("resourceDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
