package net.flask.sample;

import javax.sql.DataSource;

import net.flask.sample.dao.SimpleDao;
import net.flask.sample.dao.SimpleDaoJdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mysql.jdbc.Driver;

@Configuration
public class ApplicationContext {
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

		dataSource.setDriverClass(Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/tempdb?characterEncoding=UTF-8");
		dataSource.setUsername("simple");
		dataSource.setPassword("simple");

		return dataSource;
	}

	@Bean
	public SimpleDao simpleDao() {
		return new SimpleDaoJdbc();
	}
}
