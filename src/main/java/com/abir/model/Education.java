package com.abir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String course;
	private String subject;
	private String institution;
	private String passingYear;
	private float achievedGrade;
	private float totalGrade;
	
	
	
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Education(String course, String subject, String institution, String passingYear, float achievedGrade,
			float totalGrade) {
		super();
		this.course = course;
		this.subject = subject;
		this.institution = institution;
		this.passingYear = passingYear;
		this.achievedGrade = achievedGrade;
		this.totalGrade = totalGrade;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getPassingYear() {
		return passingYear;
	}
	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}
	public float getAchievedGrade() {
		return achievedGrade;
	}
	public void setAchievedGrade(float achievedGrade) {
		this.achievedGrade = achievedGrade;
	}
	public float getTotalGrade() {
		return totalGrade;
	}
	public void setTotalGrade(float totalGrade) {
		this.totalGrade = totalGrade;
	}
	
	
	
}
