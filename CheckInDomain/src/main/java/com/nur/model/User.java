package com.nur.model;

import core.AggregateRoot;
import core.BusinessRuleValidationException;

import java.util.UUID;

public class User extends AggregateRoot {
	public String username;

	public String accountType;

	public String email;

	public String pass;
	public UUID personId;

	public String getUsername() {
		return username;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	public UUID getPersonId() {
		return personId;
	}

	public User(String username, String email, String pass, String accountType, UUID personId) throws BusinessRuleValidationException {
		id = UUID.randomUUID();
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.accountType = accountType;
		this.personId = personId;
	}

	public User(UUID idUser, String username, String email, String pass, String accountType, UUID personId) throws BusinessRuleValidationException {
		id = idUser;
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.accountType = accountType;
		this.personId = personId;
	}
}
