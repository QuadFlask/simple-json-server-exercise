package net.flask.sample.dao;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import net.flask.sample.TestApplicationContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestApplicationContext.class)
public class SimpleDaoTest {

	@Autowired
	private SimpleDao simpleDao;

	@Test
	public void testInsertAndRead() {
		simpleDao.deleteAll();
		simpleDao.insert("testid1", "testname1");
		String result = simpleDao.getUserNameById("testid1");
		assertEquals(result, "testname1");

		simpleDao.insert("testid2", "testname2");
		result = simpleDao.getUserNameById("testid2");
		assertEquals(result, "testname2");
	}
}