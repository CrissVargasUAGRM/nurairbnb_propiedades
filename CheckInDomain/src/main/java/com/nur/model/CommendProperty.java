package com.nur.model;

import core.Entity;

import java.util.UUID;

public class CommendProperty extends Entity {
	public UUID userId;
	public String valoration;
	public String commend;
	public Integer points;
	public UUID propertyId;

	public UUID getUserId() {
		return userId;
	}

	public String getValoration() {
		return valoration;
	}

	public String getCommend() {
		return commend;
	}

	public Integer getPoints() {
		return points;
	}

	public UUID getPropertyId() {
		return propertyId;
	}

	public CommendProperty(UUID id, UUID userId, String valoration, String commend, Integer points, UUID propertyId) {
		this.id = id;
		this.userId = userId;
		this.valoration = valoration;
		this.commend = commend;
		this.points = points;
		this.propertyId = propertyId;
	}
}
