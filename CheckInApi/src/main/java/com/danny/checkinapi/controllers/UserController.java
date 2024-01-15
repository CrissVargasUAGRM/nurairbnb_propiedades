package com.danny.checkinapi.controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.UsersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import use.cases.command.users.create.CreateUserCommand;

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
}
