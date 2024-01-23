package com.nur.repositories;

import com.nur.model.CommendProperty;
import java.util.UUID;

public interface ICommendPropertyRepository {
  UUID createCommendProperty(CommendProperty commend);

  CommendProperty getById(UUID id);
}
