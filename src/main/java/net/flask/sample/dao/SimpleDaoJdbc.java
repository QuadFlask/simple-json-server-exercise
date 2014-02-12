package net.flask.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleDaoJdbc implements SimpleDao {
	private JdbcTemplate jdbcTemplate;

	private static final RowMapper<String> userNameMapper = new RowMapper<String>() {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("user_name");
		}
	};

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(String id, String name) {
		jdbcTemplate.update("insert into simpletable(user_id, user_name) values(?,?)", id, name);
	}

	@Override
	public String getUserNameById(String userId) {
		return jdbcTemplate.query("select * from simpletable where user_id=?", new Object[] { userId }, userNameMapper).get(0);
	}

	@Override
	public void deleteAll() {
		jdbcTemplate.update("delete from simpletable");
	}

}