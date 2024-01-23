package com.danny.checkinapi.controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.CommendPersonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import use.cases.command.commenPerson.create.CreateCommendPersonCommand;

@CrossOrigin(origins = "*")
@RestController
public class CommendPersonController {
	Logger logger = LoggerFactory.getLogger(CommendPersonController.class);

	final Pipeline pipeline;

	public CommendPersonController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@PostMapping("/create/commend-person")
	public CommendPersonDTO createCommendPerson(@RequestBody CommendPersonDTO commendPersonDTO){
		CreateCommendPersonCommand command = new CreateCommendPersonCommand(commendPersonDTO);
		return command.execute(pipeline);
	}
}
