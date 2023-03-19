package com.api.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.payload.UserPayload;
import com.api.app.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
@Tag(name = "CRUD REST APIs for User Resource", description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User")
public class UserController {
	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserPayload> create(@Validated @RequestBody UserPayload request) {
		UserPayload savedUser = userService.create(request);

		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<UserPayload> get(@PathVariable("id") Long id) {
		UserPayload user = userService.findById(id);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterable<UserPayload>> getAll() {
		Iterable<UserPayload> users = userService.findAll();

		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		userService.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("{id}")
	public ResponseEntity<UserPayload> update(@PathVariable("id") Long id,
			@Validated @RequestBody UserPayload request) {
		UserPayload updatedUser = userService.update(request, id);

		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
}
