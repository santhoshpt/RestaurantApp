package com.restaurant;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurant"})
@EnableJpaRepositories(basePackages = "com.restaurant")
//@EnableConfigurationProperties(RestaurantAppProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public DataSource dataSource() {
    	return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
    	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter ();
    	adapter.setDatabase(Database.H2);
    	adapter.setGenerateDdl(true);
    	adapter.setShowSql(true);
    	return adapter;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
    	LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
    	bean.setDataSource(dataSource);
    	bean.setJpaVendorAdapter(jpaVendorAdapter);
    	bean.setPackagesToScan("com.restaurant");
    	return bean;
    }
    
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
    	return new JpaTransactionManager(emf);
    }
}