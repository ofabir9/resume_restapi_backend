package com.abir.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegistrationDTO {
	
	private int id;
	
	@NotEmpty(message = "First Name cannot be Empty")
	@Size(min=2,max=30,message = "First name must be between 2 to 30 characters")
	private String firstName;
	
	@NotEmpty(message = "Last Name cannot be Empty")
	@Size(min=2,max=30,message = "Last name must be between 2 to 30 characters")
	private String lastName;
	
	@Email(message = "Provide valid email address")
	private String email;
	
	@NotEmpty(message = "Password cannot be Empty")
	private String password;
	
	@NotEmpty(message = "Repeat Password cannot be Empty")
	private String repeatPassword;

	public UserRegistrationDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
}
