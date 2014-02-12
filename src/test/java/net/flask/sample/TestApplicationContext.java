package net.flask.sample;

import javax.sql.DataSource;

import net.flask.sample.dao.SimpleDao;
import net.flask.sample.dao.SimpleDaoJdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.mysql.jdbc.Driver;

@Configuration
@ImportResource("/WEB-INF/spring/appServlet/servlet-context.xml")
public class TestApplicationContext {

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