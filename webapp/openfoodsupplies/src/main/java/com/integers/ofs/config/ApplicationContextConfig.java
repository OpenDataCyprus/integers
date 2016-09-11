package com.integers.ofs.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.integers.ofs.domain.Restaurant;
import com.integers.ofs.domain.RestaurantCategory;
import com.integers.ofs.repositories.RestaurantCategoryRepository;
import com.integers.ofs.repositories.RestaurantRepository;
import com.integers.ofs.repositories.impl.RestaurantCategoryRepositoryImpl;
import com.integers.ofs.repositories.impl.RestaurantRepositoryImpl;

@Configuration
@ComponentScan("com.integers.ofs")
@EnableTransactionManagement
@EnableWebMvc
public class ApplicationContextConfig extends WebMvcConfigurerAdapter
{
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }

	@Bean(name = "dataSource")
	DataSource dataSource() throws SQLException
	{
		final OracleDataSource dataSource = new OracleDataSource();

		dataSource.setUser("system");
		dataSource.setPassword("Oracle1");
		dataSource.setURL("jdbc:oracle:thin:@localhost:1521/XEXDB");
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);

		return dataSource;
	}

	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Restaurant.class, RestaurantCategory.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "restaurantRepository")
	public RestaurantRepository getRestaurantRepository(SessionFactory sessionFactory)
	{
		return new RestaurantRepositoryImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "restaurantCategoryRepository")
	public RestaurantCategoryRepository getRestaurantCategoryRepository(SessionFactory sessionFactory)
	{
		return new RestaurantCategoryRepositoryImpl(sessionFactory);
	}
}