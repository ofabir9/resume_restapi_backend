package com.abir.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abir.model.Employee;
import com.abir.service.AchievementService;
import com.abir.service.EducationService;
import com.abir.service.ProjectService;
import com.abir.service.SkillService;

@Repository
public class EmployeeDAOImp implements IEmployeeDAO{

	private static EmployeeDAOImp instance;
	private List<Employee> employees;
	private static int available_id;
	private SessionFactory sessionFactory;
	
	@Autowired
	private EmployeeDAOImp(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
//	private EmployeeDAOImp()
//	{
//		this.employees = new ArrayList<Employee>(Arrays.asList(
//				new Employee(1,"Omar Faruque","Abir","01759389123","github.com/ofabir9","linkedin.com/in/ofabir9","omarfaruqueabir@gmail.com","13/2 Paikpara D-type Quarter, Mirpur-1, Dhaka-1216",new EducationService().getEducations(),new SkillService().getSkills(),new ProjectService().getProjects(),new AchievementService().getAchievements()),
//				new Employee(2,"Afikur Rahman","Khan","01759389124","github.com/afikur","linkedin.com/in/afikur","afikur@gmail.com","23/7 Taltola, Mirpur-2, Dhaka-1216",new EducationService().getEducations(),new SkillService().getSkills(),new ProjectService().getProjects(),new AchievementService().getAchievements()),
//				new Employee(3,"Sazzad","Hossain","01759389125","github.com/szdhossain","linkedin.com/in/szdhossain","szdhossain@gmail.com","56/5 Rupnagar, Mirpur-6, Dhaka-1216",new EducationService().getEducations(),new SkillService().getSkills(),new ProjectService().getProjects(),new AchievementService().getAchievements())					
//				));
//		available_id = this.employees.size()+1;
//	}
	
	
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root);
		TypedQuery<Employee> query = session.createQuery(cr);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		try
		{
			Session session = sessionFactory.getCurrentSession();
			return session.get(Employee.class, id);
		}
		catch (Exception e) {
			return new Employee();
		}
		
	}

	@Override
	@Transactional
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);	
	}

	
	@Override
	@Transactional
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		//employees.remove(employee);
		System.out.println("Deleting :"+employee.getId());
		Session session = sessionFactory.getCurrentSession();
		session.delete(employee);	
	}

	@Override
	@Transactional
	public void updateEmployee(Employee editedEmployee) {
//		newEmployee.setId(oldEmployee.getId());
//		deleteEmployee(oldEmployee);
//		insertEmployee(newEmployee);
		Session session = sessionFactory.getCurrentSession();
		session.update(editedEmployee);
	}
	

}
