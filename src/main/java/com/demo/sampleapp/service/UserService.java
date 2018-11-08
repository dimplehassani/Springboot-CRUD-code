package com.demo.sampleapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.sampleapp.model.User;
import com.demo.sampleapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping(method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		User usr = new User();
		usr.setAddress(user.getAddress());
		usr.setName(user.getName());
		userRepo.saveAndFlush(usr);
		return usr;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUser() {
		return userRepo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> findOne(@PathVariable long id) {
		return userRepo.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable long id) {
		userRepo.deleteById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable long id, @RequestBody User user) {
		Optional<User> usr = userRepo.findById(id);
		if (usr.isPresent()) {
			User newUser = usr.get();
			newUser.setAddress(user.getAddress());
			newUser.setName(user.getName());
			userRepo.saveAndFlush(newUser);
		}
		return null;
	}

}
