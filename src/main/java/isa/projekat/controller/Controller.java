package isa.projekat.controller;

import isa.projekat.model.User1;
import isa.projekat.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/search/user/{name}/{lastname}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User1 getUserByName(@PathVariable String name, @PathVariable String lastname) {
		return this.userService.getUser(name, lastname);
	}
	
	@RequestMapping(value = "/search/user/{criteria}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<User1> getUserByCriteria(@PathVariable String criteria) {
		return this.userService.findUsers(criteria, new PageRequest(0, 10));
	}
}
