package com.nur.factories.commendProperty;

import com.nur.model.CommendProperty;

import java.util.UUID;

public class CommendPropertyFactoryImpl implements ICommendPropertyFactory{
	@Override
	public CommendProperty createCommend(UUID idCommend, UUID userId, String valoration, String commend, Integer points, UUID propertyId) {
		return new CommendProperty(
				idCommend,
				userId,
				valoration,
				commend,
				points,
				propertyId
		);
	}
}
