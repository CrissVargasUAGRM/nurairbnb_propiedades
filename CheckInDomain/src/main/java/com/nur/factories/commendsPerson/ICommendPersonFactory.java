package com.nur.factories.commendsPerson;

import com.nur.model.CommendPerson;

import java.util.UUID;

public interface ICommendPersonFactory {
	CommendPerson createCommend(UUID commendId, UUID userId, String valoration,Integer points, String commend, UUID personId);
}
