package com.abir.service;
import com.abir.model.Education;


import java.util.Arrays;
import java.util.List;
public class EducationService {
	List<Education> educations;
	public EducationService()
	{
		this.educations = Arrays.asList(
				new Education("B.Sc.","Computer science & Engineering","Jahangirnagar University","2020",3.67f,4.00f),
				new Education("H.S.C.","Science","Dhaka Residential Model College","2015",5.00f,5.00f),
				new Education("S.S.C.","Science","Monipur High School","2013",5.00f,5.00f)
				);
	}
	public List<Education> getEducations()
	{
		return this.educations;
	}
}
