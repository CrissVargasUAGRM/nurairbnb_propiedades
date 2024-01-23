package com.nur.model;

import core.Entity;
import java.util.UUID;

public class CommendPerson extends Entity {
  public UUID userId;
  public String valoration;
  public Integer points;
  public String commend;
  public UUID personId;

  public UUID getUserId() {
    return userId;
  }

  public String getValoration() {
    return valoration;
  }

  public Integer getPoints() {
    return points;
  }

  public String getCommend() {
    return commend;
  }

  public UUID getPersonId() {
    return personId;
  }

  public CommendPerson(
      UUID id, UUID userId, String valoration, Integer points, String commend, UUID personId) {
    this.id = id;
    this.userId = userId;
    this.valoration = valoration;
    this.points = points;
    this.commend = commend;
    this.personId = personId;
  }
}
