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
  entityManagerFactoryRef = "chatroomHistoryEntityManagerFactory",
  transactionManagerRef = "chatroomHistoryTransactionManager",
  basePackages = { "com.example.demo.dao.chatroomHistory" }
)
public class DataSource7Config {
 
  @Bean(name = "chatroomHistoryDataSource")
  @ConfigurationProperties(prefix = "chatroomHistory.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
  
  @Bean(name = "chatroomHistoryEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean 
  chatroomHistoryEntityManagerFactory(
    EntityManagerFactoryBuilder builder,
    @Qualifier("chatroomHistoryDataSource") DataSource dataSource
  ) {
    return
      builder
        .dataSource(dataSource)
        .packages("com.example.demo.entity.chatroomHistory")
        .persistenceUnit("ChatRoomHistoryEntity")
        .build();
  }
  @Bean(name = "chatroomHistoryTransactionManager")
  public PlatformTransactionManager  goodsTransactionManager(
    @Qualifier("chatroomHistoryEntityManagerFactory") EntityManagerFactory
    chatroomHistoryEntityManagerFactory
  ) {
    return new JpaTransactionManager(chatroomHistoryEntityManagerFactory);
  }
}