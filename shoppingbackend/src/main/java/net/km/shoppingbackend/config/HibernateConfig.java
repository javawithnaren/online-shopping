package net.km.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"net.km.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	//database config q
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	private static final String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
	private static final String DATABASE_DRIVER="org.h2.Driver";
	private static final String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private static final String DATABASE_USERNAME="sa";
	private static final String DATABASE_PASSWORD="";
	
	//datasource beann is available
	@Bean
	public DataSource getDataSoure(){
		BasicDataSource ds=new BasicDataSource();
		
		ds.setDriverClassName(DATABASE_DRIVER);
		ds.setUrl(DATABASE_URL);
		ds.setUsername(DATABASE_USERNAME);
		ds.setPassword(DATABASE_PASSWORD);
		return ds;
		
		
	}
	
	//SessionFactory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource ds){
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.km.shoppingbackend.dto");
	
	return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		return properties;
	}
	
	//Transaction Manager
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory fact){
	
	return new HibernateTransactionManager(fact);
}
}
