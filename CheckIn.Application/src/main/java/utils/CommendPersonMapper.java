package utils;

import com.nur.model.CommendPerson;
import dtos.CommendPersonDTO;
import java.util.UUID;

public class CommendPersonMapper {
  public static CommendPersonDTO from(CommendPerson commendPerson) {
    if (commendPerson == null) return new CommendPersonDTO();
    return new CommendPersonDTO(
        String.valueOf(commendPerson.getId()),
        String.valueOf(commendPerson.getUserId()),
        commendPerson.getValoration(),
        commendPerson.getCommend(),
        commendPerson.getPoints(),
        String.valueOf(commendPerson.getPersonId()));
  }

  public static CommendPerson from(CommendPersonDTO commendPerson) {
    return new CommendPerson(
        UUID.fromString(commendPerson.getId()),
        UUID.fromString(commendPerson.getUserId()),
        commendPerson.getValoration(),
        commendPerson.getPoints(),
        commendPerson.getCommend(),
        UUID.fromString(commendPerson.getPersonId()));
  }
}
