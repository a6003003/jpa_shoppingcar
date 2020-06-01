package com.example.demo.conf;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "selectstoreEntityManagerFactory",
  transactionManagerRef = "selectstoreTransactionManager",
  basePackages = { "com.example.demo.dao.selectstore" }
)
public class DataSource5Config {
 
  @Bean(name = "selectstoreDataSource")
  @ConfigurationProperties(prefix = "selectstore.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
  
  @Bean(name = "selectstoreEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean 
  selectstoreEntityManagerFactory(
    EntityManagerFactoryBuilder builder,
    @Qualifier("selectstoreDataSource") DataSource dataSource
  ) {
    return
      builder
        .dataSource(dataSource)
        .packages("com.example.demo.entity.selectstore")
        .persistenceUnit("SelectstoreEntity")
        .build();
  }
  @Bean(name = "selectstoreTransactionManager")
  public PlatformTransactionManager  goodsTransactionManager(
    @Qualifier("selectstoreEntityManagerFactory") EntityManagerFactory
    selectstoreEntityManagerFactory
  ) {
    return new JpaTransactionManager(selectstoreEntityManagerFactory);
  }
}