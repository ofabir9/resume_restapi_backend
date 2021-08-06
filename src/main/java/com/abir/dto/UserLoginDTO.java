package com.abir.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserLoginDTO {

	private int id;
	
	@Email(message = "Provide valid email address")
	private String email;
	
	@NotEmpty(message = "Password cannot be Empty")
	private String password;

	
	
	public UserLoginDTO() {
		super();
	}

	public UserLoginDTO(int id, @Email(message = "Provide valid email address") String email,
			@NotEmpty(message = "Password cannot be Empty") String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
