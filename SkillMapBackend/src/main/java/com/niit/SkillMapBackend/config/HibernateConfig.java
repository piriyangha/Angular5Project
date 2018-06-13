package com.niit.SkillMapBackend.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class HibernateConfig {
	
	   @Bean(name="dataSource")
	public DataSource datasource() {
	    DriverManagerDataSource datasource = new DriverManagerDataSource();
	    datasource.setDriverClassName("org.h2.Driver");
	    datasource.setUrl("jdbc:h2:tcp://localhost/~/skills");
	    datasource.setUsername("sa");
	    datasource.setPassword("123");
	    return datasource;
	 }
	 public Properties getHibernateProperties() {
	   	Properties properties=new Properties();
	   	properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	   	properties.setProperty("hibernate.show_sql", "true");
	   	properties.setProperty("hibernate.hbm2ddl.auto", "update");
	   	return properties;
	  }
	 @Bean(name="sessionFactory")
	 @Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource datasource) 
		{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(datasource);
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan("com.niit.SkillMapBackend");
		return sessionFactory;
		}
	 @Bean(name="transactionManager")
	 @Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
		{
		HibernateTransactionManager transaction=new HibernateTransactionManager();
		transaction.setSessionFactory(sessionFactory);
		return transaction;
		}


}
