package com.danny.checkinapi.controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.CommendPropertyDTO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import use.cases.command.commendProperty.create.CreateCommendPropertyCommand;
import use.cases.command.commendProperty.get.GetCommendPropertyQuery;

@CrossOrigin(origins = "*")
@RestController
public class CommendPropertyController {
  Logger logger = LoggerFactory.getLogger(CommendPropertyController.class);
  final Pipeline pipeline;

  public CommendPropertyController(Pipeline pipeline) {
    this.pipeline = pipeline;
  }

  @PostMapping("/create/commend-property")
  public CommendPropertyDTO createCommendProperty(
      @RequestBody CommendPropertyDTO commendPropertyDTO) {
    CreateCommendPropertyCommand command = new CreateCommendPropertyCommand(commendPropertyDTO);
    return command.execute(pipeline);
  }

  @GetMapping("/commends/{propId}")
  public List<CommendPropertyDTO> getCommends(@PathVariable String propId) {
    GetCommendPropertyQuery query = new GetCommendPropertyQuery(propId);
    return query.execute(pipeline);
  }
}
