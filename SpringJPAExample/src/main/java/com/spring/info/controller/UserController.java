package com.spring.info.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.Resources;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
//import org.springframework.hateoas.server.mvc.ControllerLinkBuilderFactory;
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
import com.spring.info.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public List<User> findAllUsers() {

		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {

		User fetchUser = service.findOne(id);
		// wrinting or enabling or using auto configured exceptions
		if (fetchUser == null) {
			throw new UserNotFoundException(" id not avilable ramaiah Pillala - " + id);
		}
		return fetchUser;
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/usersHateoAS/{id}")
	public Resource<User> getUserByIdHateoAs(@PathVariable int id) {
		User fetchUser = service.findOne(id);
		if (fetchUser == null) {
			throw new UserNotFoundException(" id not avilable ramaiah Pillala - " + id);
		}
		Resource<User> resource = new Resource<User>(fetchUser);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAllUsers());
		resource.add(linkTo.withRel("find the total user information : "));
		return resource;
	}

	// implementing HATEOAS functionality
	// HATEOAS - Hypermedi as the Engine of the Application Status
	// it will not only fetch required user data, it will fetch user data and also
	// send the link
	// to fetch all user data
	// for this add entry in pom.xml

	@PostMapping("/addUser")
	public User addUser(@Valid @RequestBody User user) {
		User addUserInfo = service.save(user);

		return addUserInfo;
	}

// here writing one more method ot create/add user with getting best Http status code like 201

	@PostMapping("/addUser201")
	public ResponseEntity<Object> addUserFor201(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {

		User deleteUser = service.deleteById(id);
		// wrinting or enabling or using auto configured exceptions
		if (deleteUser == null) {
			throw new UserNotFoundException(" id for - " + id);
		}

	}

}
