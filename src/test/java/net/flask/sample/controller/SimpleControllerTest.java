package net.flask.sample.controller;

import net.flask.sample.ApplicationContext;
import net.flask.sample.TestApplicationContext;
import static org.hamcrest.core.Is.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestApplicationContext.class)
public class SimpleControllerTest {
	
	@Autowired
	private WebApplicationContext applicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = webAppContextSetup(applicationContext).dispatchOptions(true).build();
	}
	
	@Test
	public void test() throws Exception {
		assertUserIdNadName("testid1", "testname1");
		assertUserIdNadName("testid2", "testname2");
	}

	private void assertUserIdNadName(String id, String expectedName) throws Exception {
		mockMvc.perform(get("/getUser").param("userId", id).accept(MediaType.APPLICATION_JSON)) 
		      .andExpect(status().isOk())
		      .andExpect(jsonPath("$.id").value(id))
		      .andExpect(jsonPath("$.name").value(expectedName));
	}
}


