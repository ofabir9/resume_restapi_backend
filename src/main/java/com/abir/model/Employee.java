package com.abir.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.URL;

import com.sun.istack.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Employee")
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ApiModelProperty(name="First Name",dataType="String",value="First name",required=true)
	private String firstName;
	
	@ApiModelProperty(name="Last Name",dataType="String",value="Last name",required=true)
	private String lastName;
	
	@ApiModelProperty(name="Mobile",dataType="String",value="Mobile",required=true)
	private String mobile;
	
	@ApiModelProperty(name="Github",dataType="String",value="Github",required=true)
	private String github;
	
	@ApiModelProperty(name="Linkedin",dataType="String",value="Linkedin",required=true)
	private String linkedin;
	
	@ApiModelProperty(name="Email",dataType="String",value="Email",required=true)
	private String email;
	
	
	private String password;
	
	@ApiModelProperty(name="Address",dataType="String",value="Address")
	private String address;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Education> educations;
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Skill> skills;
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Project> projects;
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Achievement> achievements;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String firstName, String lastName, List<Education> educations, List<Skill> skills,
			List<Project> projects, List<Achievement> achievements) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.educations = educations;
		this.skills = skills;
		this.projects = projects;
		this.achievements = achievements;
	}
	public Employee(int id, String firstName, String lastName, String mobile, String github, String linkedin,
			String email,String password, String address, List<Education> educations, List<Skill> skills, List<Project> projects,
			List<Achievement> achievements) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.github = github;
		this.linkedin = linkedin;
		this.email = email;
		this.password = password;
		this.address = address;
		this.educations = educations;
		this.skills = skills;
		this.projects = projects;
		this.achievements = achievements;
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
	public List<Education> getEducations() {
		return educations;
	}
	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public List<Achievement> getAchievements() {
		return achievements;
	}
	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFullName() {
		return firstName+" "+lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
