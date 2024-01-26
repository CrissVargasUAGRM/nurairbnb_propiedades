package com.danny.checkinapi.controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.LoginResponseDTO;
import dtos.LoginUserDTO;
import dtos.UsersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import use.cases.command.login.LoginUserCommand;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	final Pipeline pipeline;

	public LoginController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@PostMapping("login")
	public LoginResponseDTO login(@RequestBody LoginUserDTO credentials){
		LoginUserCommand command = new LoginUserCommand(credentials);
		return command.execute(pipeline);
	}
}
