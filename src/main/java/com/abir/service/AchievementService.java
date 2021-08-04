package com.abir.service;

import com.abir.model.Achievement;
import java.util.List;
import java.util.Arrays;
public class AchievementService {
	List<Achievement> achievements;
	public AchievementService()
	{
		this.achievements = Arrays.asList(
				new Achievement("The 2017 ACM-ICPC Asia Dhaka Regional Contest","45th place"),
				new Achievement("The 2017 ACM-ICPC Asia Dhaka Regional Contest","100th place"),
				new Achievement("BACS-BUBT national programing camp 2017","1st place"),
				new Achievement("Banglalion-Sub Inter University Programming Contest-2018","25th place"),
				new Achievement("Codeforces rank","Expert (max)"),
				new Achievement("UVA online judge problem accepted","350+"),
				new Achievement("Other online judges problem solved","700+")
				);
	}
	public List<Achievement> getAchievements()
	{
		return this.achievements;
	}
}
