package com.nur.repositories;

import com.nur.model.CommendPerson;

import java.util.UUID;

public interface ICommendPersonRepository {
	UUID createCommend(CommendPerson commend);
	CommendPerson getById(UUID commendId);
}
