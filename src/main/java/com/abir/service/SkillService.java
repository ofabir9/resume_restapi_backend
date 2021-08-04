package com.abir.service;

import com.abir.model.Skill;

import java.util.Arrays;
import java.util.List;

public class SkillService {
	List<Skill> skills;
	public SkillService()
	{
		this.skills = Arrays.asList(
				new Skill("Programming Languages",Arrays.asList("C","C++","C#","JAVA","PYTHON")),
				new Skill("Database",Arrays.asList("MYSQL","NOSQL")),
				new Skill("Architecture",Arrays.asList("MVC")),
				new Skill("Others",Arrays.asList("Data Structures","Algorithms"))
				);
	}
	public List<Skill> getSkills()
	{
		return this.skills;
	}
}
