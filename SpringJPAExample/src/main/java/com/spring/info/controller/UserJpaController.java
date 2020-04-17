package com.spring.info.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.info.beans.User;
import com.spring.info.exception.UserNotFoundException;
import com.spring.info.repository.UserJpaRepository;
import com.spring.info.service.UserService;

@RestController
public class UserJpaController {

	@Autowired
	private UserService service;

	@Autowired
	private UserJpaRepository repository;

	@GetMapping("/jpa/users")
	public List<User> findAllUsers() {

		return repository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public Resource<User> getUserById(@PathVariable int id) {

		Optional<User> user = repository.findById(id);
		// wrinting or enabling or using auto configured exceptions
		if (!user.isPresent()) {
			throw new UserNotFoundException(" id not avilable ramaiah Pillala - " + id);
		}
		Resource<User> resource = new Resource<User>(user.get());
		return resource;
	}

	@PostMapping("/jpa/addUser")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User addUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {

		repository.deleteById(id);

	}

}
