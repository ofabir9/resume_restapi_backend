package com.abir.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

public class EmployeeDTO{
	
	private int id;
	
	@NotEmpty(message = "First Name cannot be Empty")
	@Size(min=2,max=30,message = "First name must be between 2 to 30 characters")
	private String firstName;
	
	@NotEmpty(message = "Last Name cannot be Empty")
	@Size(min=2,max=30,message = "Last name must be between 2 to 30 characters")
	private String lastName;
	
	@NotNull(message = "Mobile number cannot be null")
	@NotEmpty(message = "Mobile number cannot be Empty")
	@Pattern(regexp="(^$|[0-9]{8,13})",message="Provice valid mobile number")
	private String mobile;
	
	@NotNull(message = "Github link cannot be null")
	@URL(message = "Enter valid url")
	private String github;
	
	@NotNull(message = "Linkdin link cannot be null")
	@URL(message = "Enter valid url")
	private String linkedin;
	
	@Email(message = "Provice valid email address")
	private String email;
	
	@NotEmpty(message = "Address cannot be Empty")
	@Size(min=2,max=60,message = "Address must be between 2 to 60 characters")
	private String address;
	
	List<String> educationCourses ;
	List<String> educationSubjects ;
	List<String> educationInstitutions ;
	List<String> educationPassingYears ;
	List<String> educationAchievedGrades ;
	List<String> educationTotalGrades ;
    
	List<String> skillTypes ;
	List<String> skillNamess ;
    
	List<String> projectNames ;
	List<String> projectDescriptions ;
	List<String> projectLanguagess ;
	List<String> projectToolss ;
    
	List<String> achievementNames ;
	List<String> achievementDescriptions ;
	
	public List<String> getEducationCourses() {
		return educationCourses;
	}
	public void setEducationCourses(List<String> educationCourses) {
		this.educationCourses = educationCourses;
	}
	public List<String> getEducationSubjects() {
		return educationSubjects;
	}
	public void setEducationSubjects(List<String> educationSubjects) {
		this.educationSubjects = educationSubjects;
	}
	public List<String> getEducationInstitutions() {
		return educationInstitutions;
	}
	public void setEducationInstitutions(List<String> educationInstitutions) {
		this.educationInstitutions = educationInstitutions;
	}
	public List<String> getEducationPassingYears() {
		return educationPassingYears;
	}
	public void setEducationPassingYears(List<String> educationPassingYears) {
		this.educationPassingYears = educationPassingYears;
	}
	public List<String> getEducationAchievedGrades() {
		return educationAchievedGrades;
	}
	public void setEducationAchievedGrades(List<String> educationAchievedGrades) {
		this.educationAchievedGrades = educationAchievedGrades;
	}
	public List<String> getEducationTotalGrades() {
		return educationTotalGrades;
	}
	public void setEducationTotalGrades(List<String> educationTotalGrades) {
		this.educationTotalGrades = educationTotalGrades;
	}
	public List<String> getSkillTypes() {
		return skillTypes;
	}
	public void setSkillTypes(List<String> skillTypes) {
		this.skillTypes = skillTypes;
	}
	public List<String> getSkillNamess() {
		return skillNamess;
	}
	public void setSkillNamess(List<String> skillNamess) {
		this.skillNamess = skillNamess;
	}
	public List<String> getProjectNames() {
		return projectNames;
	}
	public void setProjectNames(List<String> projectNames) {
		this.projectNames = projectNames;
	}
	public List<String> getProjectDescriptions() {
		return projectDescriptions;
	}
	public void setProjectDescriptions(List<String> projectDescriptions) {
		this.projectDescriptions = projectDescriptions;
	}
	public List<String> getProjectLanguagess() {
		return projectLanguagess;
	}
	public void setProjectLanguagess(List<String> projectLanguagess) {
		this.projectLanguagess = projectLanguagess;
	}
	public List<String> getProjectToolss() {
		return projectToolss;
	}
	public void setProjectToolss(List<String> projectToolss) {
		this.projectToolss = projectToolss;
	}
	public List<String> getAchievementNames() {
		return achievementNames;
	}
	public void setAchievementNames(List<String> achievementNames) {
		this.achievementNames = achievementNames;
	}
	public List<String> getAchievementDescriptions() {
		return achievementDescriptions;
	}
	public void setAchievementDescriptions(List<String> achievementDescriptions) {
		this.achievementDescriptions = achievementDescriptions;
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
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", github=" + github + ", linkedin=" + linkedin + ", email=" + email + ", address=" + address
				+ ", educationCourses=" + educationCourses + ", educationSubjects=" + educationSubjects
				+ ", educationInstitutions=" + educationInstitutions + ", educationPassingYears="
				+ educationPassingYears + ", educationAchievedGrades=" + educationAchievedGrades
				+ ", educationTotalGrades=" + educationTotalGrades + ", skillTypes=" + skillTypes + ", skillNamess="
				+ skillNamess + ", projectNames=" + projectNames + ", projectDescriptions=" + projectDescriptions
				+ ", projectLanguagess=" + projectLanguagess + ", projectToolss=" + projectToolss
				+ ", achievementNames=" + achievementNames + ", achievementDescriptions=" + achievementDescriptions
				+ "]";
	}
	
	
	
	

}
