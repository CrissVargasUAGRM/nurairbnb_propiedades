package infraestructure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Persons")
public class PersonJpaModel {
  @Id
  @Column(name = "ID_PERSON")
  private UUID id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "CI")
  private String ci;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCi() {
    return ci;
  }

  public void setCi(String ci) {
    this.ci = ci;
  }
}
