package net.flask.sample.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.flask.sample.dao.SimpleDao;
import net.flask.sample.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller("simpleController")
public class SimpleController {

	@Resource
	private SimpleDao simpleDao;

	private static Gson gson = new Gson();

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public String getUser(@RequestParam String userId, HttpServletResponse response) {
	    response.setContentType("application/json");
	    
		String name = simpleDao.getUserNameById(userId);
		
		User user = new User();
		user.setId(userId);
		user.setName(name);
		
		String result = gson.toJson(user);
		return result;
	}

}

