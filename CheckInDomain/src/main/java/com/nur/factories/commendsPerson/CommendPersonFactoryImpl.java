package com.nur.factories.commendsPerson;

import com.nur.model.CommendPerson;
import java.util.UUID;

public class CommendPersonFactoryImpl implements ICommendPersonFactory {

  @Override
  public CommendPerson createCommend(
      UUID commendId,
      UUID userId,
      String valoration,
      Integer points,
      String commend,
      UUID personId) {
    return new CommendPerson(commendId, userId, valoration, points, commend, personId);
  }
}
