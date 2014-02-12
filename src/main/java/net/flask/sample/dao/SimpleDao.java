package net.flask.sample.dao;

import javax.sql.DataSource;

public interface SimpleDao {
	public void setDataSource(DataSource dataSource);

	public void insert(String string, String string2);

	public String getUserNameById(String string);

	public void deleteAll();
}