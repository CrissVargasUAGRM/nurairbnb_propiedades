package com.nur.factories.commendProperty;

import com.nur.model.CommendProperty;

import java.util.UUID;

public interface ICommendPropertyFactory {
	CommendProperty createCommend(UUID idCommend, UUID userId, String valoration, String commend, Integer points, UUID propertyId);
}
