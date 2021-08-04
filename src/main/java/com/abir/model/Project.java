package com.abir.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	List<String> languages;
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	List<String> tools;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String name, String description, List<String> languages, List<String> tools) {
		super();
		this.name = name;
		this.description = description;
		this.languages = languages;
		this.tools = tools;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public List<String> getTools() {
		return tools;
	}
	public void setTools(List<String> tools) {
		this.tools = tools;
	}
	
	
}
