package com.danny.checkinapi.controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.UsersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import use.cases.command.users.create.CreateUserCommand;
import use.cases.command.users.get.GetUserQuery;

import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);

	final Pipeline pipeline;

	public UserController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@PostMapping("/create-user")
	public UsersDTO createUser(@RequestBody UsersDTO usersDTO){
		CreateUserCommand command = new CreateUserCommand(usersDTO);
		return command.execute(pipeline);
	}

	@GetMapping("/user/{userId}")
	public UsersDTO getUser(@PathVariable String userId){
		GetUserQuery query = new GetUserQuery(UUID.fromString(userId));
		return query.execute(pipeline);
	}
}
