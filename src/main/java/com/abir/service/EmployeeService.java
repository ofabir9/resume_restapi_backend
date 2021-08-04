package com.abir.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abir.dao.EmployeeDAOImp;
import com.abir.dao.IEmployeeDAO;
import com.abir.dto.EmployeeDTO;
import com.abir.model.Achievement;
import com.abir.model.Education;
import com.abir.model.Employee;
import com.abir.model.Project;
import com.abir.model.Skill;
import com.abir.validator.EmployeeValidator;

@Service
public class EmployeeService {
	
	
	private IEmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeService(IEmployeeDAO employeeDao)
	{
		this.employeeDao = employeeDao;
	}
	
	public List<Employee> getAllEmployees()
	{
		return employeeDao.getAllEmployees();
	}
	
	public Employee getEmployeeById(int id)
	{
		return employeeDao.getEmployeeById(id);
		
	}
	public void insertEmployee(Employee employee)
	{
		this.employeeDao.insertEmployee(employee);
	}
	
	public void deleteEmployee(Employee employee)
	{
		employeeDao.deleteEmployee(employee);
	}
	public void updateEmployee(Employee editedEmployee)
	{
		employeeDao.updateEmployee(editedEmployee);
	}
	public Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
		
		
			
					
			        Employee employee = new Employee();
			        
			        employee.setId(employeeDTO.getId());
			        employee.setFirstName(employeeDTO.getFirstName());
			        employee.setLastName(employeeDTO.getLastName());
			        employee.setMobile(employeeDTO.getMobile());
			        employee.setGithub(employeeDTO.getGithub());
			        employee.setLinkedin(employeeDTO.getLinkedin());
			        employee.setEmail(employeeDTO.getEmail());
			        employee.setAddress(employeeDTO.getAddress());
			        
   
			        List<Education> educations = new ArrayList<Education>();
			        List<Skill> skills = new ArrayList<Skill>();
			        List<Project> projects = new ArrayList<Project>();
			        List<Achievement> achievements = new ArrayList<Achievement>();
			        
			        
			        List<String> educationCourses = employeeDTO.getEducationCourses();
			        List<String> educationSubjects = employeeDTO.getEducationSubjects();
			        List<String> educationInstitutions = employeeDTO.getEducationInstitutions();
			        List<String> educationPassingYears = employeeDTO.getEducationPassingYears();
			        List<String> educationAchievedGrades = employeeDTO.getEducationAchievedGrades();
			        List<String> educationTotalGrades = employeeDTO.getEducationTotalGrades();
			        
			        List<String> skillTypes = employeeDTO.getSkillTypes();
			        List<String> skillNamess = employeeDTO.getSkillNamess();
			        
			        List<String>projectNames = employeeDTO.getProjectNames();
			        List<String> projectDescriptions = employeeDTO.getProjectDescriptions();
			        List<String> projectLanguagess = employeeDTO.getProjectLanguagess();
			        List<String> projectToolss = employeeDTO.getProjectToolss();
			        
			        List<String>achievementNames = employeeDTO.getAchievementNames();
			        List<String> achievementDescriptions = employeeDTO.getAchievementDescriptions();
			        
			        System.out.println(educationCourses);
			        System.out.println(educationSubjects);
			        System.out.println(educationInstitutions);
			        System.out.println(educationPassingYears);
			        System.out.println(educationAchievedGrades);
			        System.out.println(educationTotalGrades);
			        if(educationCourses!=null)
			        for (int i = 0; i < educationCourses.size(); i++) {
			            educations.add(new Education(educationCourses.get(i),educationSubjects.get(i),educationInstitutions.get(i),educationPassingYears.get(i),Float.parseFloat(educationAchievedGrades.get(i)),Float.parseFloat(educationTotalGrades.get(i))));
			        }
			        employee.setEducations(educations);

			        if(skillTypes!=null)
			        for (int i = 0; i < skillTypes.size(); i++) {
			        	List<String> skillNames = new ArrayList<>(Arrays.asList());
			        	skillNames = new ArrayList<>(Arrays.asList(skillNamess.get(i).split(",")));
			        	skills.add(new Skill(skillTypes.get(i),skillNames));
			        }
			        employee.setSkills(skills);

			        if(projectNames!=null)
			        for (int i = 0; i < projectNames.size(); i++) {  
			        	List<String> projectLanguages = Arrays.asList();
			        	projectLanguages = new ArrayList<>(Arrays.asList(projectLanguagess.get(i).split(",")));
			        	List<String> projectTools = Arrays.asList();
			        	projectTools = new ArrayList<>(Arrays.asList(projectToolss.get(i).split(",")));		        	
			        	projects.add(new Project(projectNames.get(i),projectDescriptions.get(i),projectLanguages,projectTools));
			        }
			        employee.setProjects(projects);
			          
			        if(achievementNames!=null)
			        for(int i = 0; i < achievementNames.size() ; i++ )
			        {
			        	achievements.add(new Achievement(achievementNames.get(i),achievementDescriptions.get(i)));
			        }
			        employee.setAchievements(achievements);
			        
			        
			        
			        List<String>errors = EmployeeValidator.getErrors(employee);
		return employee;
	}
	public EmployeeDTO employeeToEmployeeDTO(Employee employee)
	{
		EmployeeDTO employeeDTO = new EmployeeDTO();
        
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setMobile(employee.getMobile());
        employeeDTO.setGithub(employee.getGithub());
        employeeDTO.setLinkedin(employee.getLinkedin());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setAddress(employee.getAddress());
        
        
        List<Education> educations = employee.getEducations() ;
    	List<Skill> skills = employee.getSkills();
    	List<Project> projects = employee.getProjects();
    	List<Achievement> achievements = employee.getAchievements();
    	
    	List<String> educationCourses = new ArrayList<String>();
    	List<String> educationSubjects = new ArrayList<String>();
    	List<String> educationInstitutions = new ArrayList<String>();
    	List<String> educationPassingYears = new ArrayList<String>();
    	List<String> educationAchievedGrades = new ArrayList<String>();
    	List<String> educationTotalGrades = new ArrayList<String>();
    	
    	List<String> skillTypes = new ArrayList<String>();
    	List<String> skillNamess = new ArrayList<String>();
        
    	List<String> projectNames = new ArrayList<String>();
    	List<String> projectDescriptions = new ArrayList<String>();
    	List<String> projectLanguagess = new ArrayList<String>();
    	List<String> projectToolss = new ArrayList<String>();
        
    	List<String> achievementNames = new ArrayList<String>();
    	List<String> achievementDescriptions = new ArrayList<String>();
    	
    	if(educations!=null)
    	{
    		for(Education education : educations)
    		{
    			educationCourses.add(education.getCourse());
    			educationSubjects.add(education.getSubject());
    			educationInstitutions.add(education.getInstitution());
    			educationPassingYears.add(education.getPassingYear());
    			educationAchievedGrades.add(String. valueOf(education.getAchievedGrade()));
    			educationTotalGrades.add(String. valueOf(education.getTotalGrade()));
    		}
    		employeeDTO.setEducationCourses(educationCourses);
    		employeeDTO.setEducationSubjects(educationSubjects);
    		employeeDTO.setEducationInstitutions(educationInstitutions);
    		employeeDTO.setEducationPassingYears(educationPassingYears);
    		employeeDTO.setEducationAchievedGrades(educationAchievedGrades);
    		employeeDTO.setEducationTotalGrades(educationTotalGrades);
    	}
    	
    	if(skills!=null)
    	{
    		for(Skill skill:skills)
    		{
    			skillTypes.add(skill.getSkillType());
    			
    			List<String>skillNames= skill.getSkillNames();
    			String skillNameString = "";
    			for(int i=0;i<skillNames.size();i++)
    			{
    				if(i!=0)skillNameString+=", ";
    				skillNameString+=skillNames.get(i);
    			}
    			skillNamess.add(skillNameString);
    		}
    		employeeDTO.setSkillTypes(skillTypes);
    		employeeDTO.setSkillNamess(skillNamess);
    	}
    	
    	if(projects!=null)
    	{
    		for(Project project:projects)
    		{
    			projectNames.add(project.getName());
    			projectDescriptions.add(project.getDescription());
    			
    			List<String>projectLanguages= project.getLanguages();
    			String projectLanguagesString = "";
    			for(int i=0;i<projectLanguages.size();i++)
    			{
    				if(i!=0)projectLanguagesString+=", ";
    				projectLanguagesString+=projectLanguages.get(i);
    			}
    			projectLanguagess.add(projectLanguagesString);
    			
    			List<String>projectTools= project.getTools();
    			String projectToolsString = "";
    			for(int i=0;i<projectTools.size();i++)
    			{
    				if(i!=0)projectToolsString+=", ";
    				projectToolsString+=projectTools.get(i);
    			}
    			projectToolss.add(projectToolsString);
    		}
    		employeeDTO.setProjectNames(projectNames);
    		employeeDTO.setProjectDescriptions(projectDescriptions);
    		employeeDTO.setProjectLanguagess(projectLanguagess);
    		employeeDTO.setProjectToolss(projectToolss);
    	}
    	
    	if(achievements!=null)
    	{
    		for(Achievement achievement : achievements)
    		{
    			achievementNames.add(achievement.getName());
    			achievementDescriptions.add(achievement.getDescription());
    			
    		}
    		employeeDTO.setAchievementNames(achievementNames);
    		employeeDTO.setAchievementDescriptions(achievementDescriptions);
    	}
    	
		return employeeDTO;
	}
	
}
