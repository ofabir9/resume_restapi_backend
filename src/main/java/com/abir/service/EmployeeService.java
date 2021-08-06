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
	public Employee insertEmployee(Employee employee)
	{
		return this.employeeDao.insertEmployee(employee);
	}
	
	public void deleteEmployee(Employee employee)
	{
		employeeDao.deleteEmployee(employee);
	}
	public void updateEmployee(Employee editedEmployee)
	{
		employeeDao.updateEmployee(editedEmployee);
	}
	public Employee getEmployeeByEmail(String email) {
		return employeeDao.getEmployeeByEmail(email);
	}
	
}
