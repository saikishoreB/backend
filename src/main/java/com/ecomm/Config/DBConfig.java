package com.ecomm.Config;

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

import com.ecomm.DAO.CartItemDAO;
import com.ecomm.DAO.CategoryDAO;
import com.ecomm.DAO.CustomerDAO;
import com.ecomm.DAO.ProductDAO;
import com.ecomm.DAO.SupplierDAO;
import com.ecomm.DAO.UserDAO;
import com.ecomm.DAOImpl.CartItemDAOImpl;
import com.ecomm.DAOImpl.CategoryDAOImpl;
import com.ecomm.DAOImpl.CustomerDAOImpl;
import com.ecomm.DAOImpl.ProductDAOImpl;
import com.ecomm.DAOImpl.SupplierDAOImpl;
import com.ecomm.DAOImpl.UserDAOImpl;

@Configuration
@ComponentScan("com.ecomm.Model")
@EnableTransactionManagement

public class DBConfig {
	@Bean(name="sessionFactory")
	@Autowired
    public LocalSessionFactoryBean sessionFactory() 
	{
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.ecomm.Model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        System.out.println("SessionCreated");
        return sessionFactory;
     }
	@Bean(name="dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("sai");
        dataSource.setPassword("1234");
        System.out.println("---Data Sources is Created---");
		return dataSource;
}

	 private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.setProperty("hibernate.show_sql","true");
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			properties.setProperty("hibernate.hbm2ddl.auto","none");
			System.out.println("---SessionFactory Object is Created---");
	        return properties;        
	    }

	 @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s)
	 {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
		   System.out.println("---Transcation Manager object Created---");
           return txManager;
	    }
	
}



