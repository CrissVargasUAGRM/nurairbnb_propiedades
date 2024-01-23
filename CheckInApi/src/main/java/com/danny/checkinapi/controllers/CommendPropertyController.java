package com.danny.checkinapi.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.model.CommendProperty;
import dtos.CommendPropertyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import use.cases.command.commendProperty.create.CreateCommendPropertyCommand;

@CrossOrigin(origins = "*")
@RestController
public class CommendPropertyController {
	Logger logger = LoggerFactory.getLogger(CommendPropertyController.class);
	final Pipeline pipeline;

	public CommendPropertyController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@PostMapping("/create/commend-property")
	public CommendPropertyDTO createCommendProperty(@RequestBody CommendPropertyDTO commendPropertyDTO){
		CreateCommendPropertyCommand command = new CreateCommendPropertyCommand(commendPropertyDTO);
		return command.execute(pipeline);
	}
}
