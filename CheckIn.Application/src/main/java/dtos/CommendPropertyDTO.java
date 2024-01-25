package dtos;

public class CommendPropertyDTO {
  public String id;
  public String userId;
  public String valoration;
  public String commend;
  public Integer points;
  public String propertyId;

  public CommendPropertyDTO() {}

  public CommendPropertyDTO(
      String id,
      String userId,
      String valoration,
      String commend,
      Integer points,
      String propertyId) {
    this.id = id;
    this.userId = userId;
    this.valoration = valoration;
    this.commend = commend;
    this.points = points;
    this.propertyId = propertyId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
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

  public String getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(String propertyId) {
    this.propertyId = propertyId;
  }
}
