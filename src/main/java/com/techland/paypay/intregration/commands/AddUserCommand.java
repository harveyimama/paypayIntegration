package com.techland.paypay.intregration.commands;

public class AddUserCommand {
	
	@Override
	public String toString() {
		return "{\"class\":\"AddUserCommand\",\"id\":\"" + id + "\", \"username\":\"" + username + "\", \"password\":\""
				+ password + "\", \"email\":\"" + email + "\", \"fullname\":\"" + fullname + "\", \"role\":\"" + role
				+ "\", \"userType\":\"" + userType + "\"}";
	}

	private String id;
	private String username;
	private String password;
	private String email;
	private String fullname;
	private String role;
	private String userType;


	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = UserSecurity.encrypt(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
