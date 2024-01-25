package infraestructure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "CommendProperty")
public class CommendPropertyJpaModel {
  @Id
  @Column(name = "COMMEND_ID")
  private UUID id;

  @Column(name = "USER_ID")
  private UUID userId;

  @Column(name = "VALORATION")
  private String valoration;

  @Column(name = "COMMEND")
  private String commend;

  @Column(name = "POINTS")
  private Integer points;

  @Column(name = "PROPERTY_ID")
  private UUID propertyId;

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

  public String getCommend() {
    return commend;
  }

  public void setCommend(String commend) {
    this.commend = commend;
  }

  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public UUID getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(UUID propertyId) {
    this.propertyId = propertyId;
  }
}
