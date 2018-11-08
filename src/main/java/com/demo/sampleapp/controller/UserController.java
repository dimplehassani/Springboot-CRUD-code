package com.demo.sampleapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sampleapp.model.User;
import com.demo.sampleapp.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUser() {
		return userService.getUser();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> findOne(@PathVariable long id) {
		return userService.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
}
