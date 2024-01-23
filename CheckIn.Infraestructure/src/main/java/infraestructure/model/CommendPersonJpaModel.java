package infraestructure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "CommendPerson")
public class CommendPersonJpaModel {
  @Id
  @Column(name = "ID_COMMEND")
  private UUID id;

  @Column(name = "USER_ID")
  private UUID userId;

  @Column(name = "VALORATION")
  private String valoration;

  @Column(name = "POINTS")
  private Integer points;

  @Column(name = "COMMEND")
  private String commend;

  @Column(name = "PERSON_ID")
  private UUID personId;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public String getValoration() {
    return valoration;
  }

  public void setValoration(String valoration) {
    this.valoration = valoration;
  }

  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public String getCommend() {
    return commend;
  }

  public void setCommend(String commend) {
    this.commend = commend;
  }

  public UUID getPersonId() {
    return personId;
  }

  public void setPersonId(UUID personId) {
    this.personId = personId;
  }
}
