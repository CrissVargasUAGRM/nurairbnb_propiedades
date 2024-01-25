package com.nur.repositories;

import com.nur.model.CommendProperty;
import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;

public interface ICommendPropertyRepository {
  UUID createCommendProperty(CommendProperty commend);

  CommendProperty getById(UUID id);

  List<CommendProperty> getByPropiedadId(UUID idPropiedad) throws BusinessRuleValidationException;;
}
