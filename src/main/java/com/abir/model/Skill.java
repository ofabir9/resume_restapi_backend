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
public class Skill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String skillType;
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<String> skillNames;
	
	public Skill() {
		super();
	}
	
	public Skill(String skillType, List<String> skillNames) {
		super();
		this.skillType = skillType;
		this.skillNames = skillNames;
	}
	@Override
	public String toString() {
		return "Skill [skillType=" + skillType + ", skillNames=" + skillNames + "]";
	}
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public List<String> getSkillNames() {
		return skillNames;
	}
	public void setSkillNames(List<String> skillNames) {
		this.skillNames = skillNames;
	}
		
}
