package dtos;

public class LoginResponseDTO {
	public String userId;
	public String userName;
	public String accountType;
	public String personId;

	public LoginResponseDTO() {
	}

	public LoginResponseDTO(String userId, String userName, String accountType, String personId) {
		this.userId = userId;
		this.userName = userName;
		this.accountType = accountType;
		this.personId = personId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
}
