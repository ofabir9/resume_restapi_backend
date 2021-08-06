package com.abir.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abir.dto.EmployeeDTO;
import com.abir.dto_to_model_converter.DTOToModelConverter;
import com.abir.model.Employee;
import com.abir.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@Api(value="Resume API",tags="Resume api for employees")
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@ModelAttribute("employeeDTO")
	public EmployeeDTO getEmployeeDTO()
	{
		return new EmployeeDTO();
	}
	
	@ApiOperation(value="Returns Employees' Resumes' List")
	@ApiResponses(value= {
			@ApiResponse(code=404,message = "Can't fetch Employees List"),
			@ApiResponse(code=200,message = "Employees List")
	})
	@GetMapping()
	public ResponseEntity<?> allEmployees(Model model)
	{
		try
		{
			List<Employee> employeeList = employeeService.getAllEmployees();
			return new ResponseEntity<>(employeeList,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Can't fetch Employees List",HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Returns Resume of a single Employee")
	@ApiParam(value="Employee Id",required = true)
	@ApiResponses(value= {
			@ApiResponse(code=404,message = "Can't fetch Employee Resume"),
			@ApiResponse(code=200,message = "Employee's Resume")
	})
	@GetMapping("/show/{id}")
	public ResponseEntity<?> showResume(@PathVariable("id") int id, Model model)
	{
		try
		{
			Employee employee = employeeService.getEmployeeById(id);
			return new ResponseEntity<>(employee,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Can't fetch Employee / Employee Doesn't Exist",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@ApiOperation(value="Add a new Employee's Resume")
	@ApiResponses(value= {
			@ApiResponse(code=400,message = "Can't add Employee Resume"),
			@ApiResponse(code=201,message = "Employee's Resume added")
	})
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO,BindingResult result, Model model)
	{
		
		if(result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			Map<String,List<String>> map = new HashMap<>();
			map.put("errors", errors);
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		
		employeeService.insertEmployee(DTOToModelConverter.employeeDTOToEmployee(employeeDTO));
		
		
		return new ResponseEntity<Boolean>(true,HttpStatus.CREATED); 
	}
	@ApiOperation(value="Returns Employee's Resume for editing")
	@ApiParam(value="Employee Id",required = true)
	@ApiResponses(value= {
			@ApiResponse(code=400,message = "Can't get Employee Resume data"),
			@ApiResponse(code=200,message = "Employee's Resume data")
	})
	@GetMapping("/edit/{id}")
	public ResponseEntity<?> showEditEmployeeForm(@PathVariable("id") int id,Model model)
	{
		Employee employee = employeeService.getEmployeeById(id);
		if(employee!=null)
		{
			return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Employee Not Found",HttpStatus.BAD_REQUEST);
		}
	}
	@ApiOperation(value="Updates Employee's Resume")
	@ApiResponses(value= {
			@ApiResponse(code=400,message = "Can't update Employee Resume data"),
			@ApiResponse(code=201,message = "Employee's Resume data updated")
	})
	@PutMapping("/update")
	public ResponseEntity<?> saveEditEmployee(@Valid @RequestBody EmployeeDTO employeeDTO,BindingResult result,Model model) {
			
		if(result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			Map<String,List<String>> map = new HashMap<>();
			map.put("errors", errors);
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}

		employeeService.updateEmployee(DTOToModelConverter.employeeDTOToEmployee(employeeDTO));
		
		return new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
	}
	@ApiOperation(value="Deletes Employee's Resume")
	@ApiParam(value="Employee Id",required = true)
	@ApiResponses(value= {
			@ApiResponse(code=400,message = "Can not delete employee resume"),
			@ApiResponse(code=200,message = "Employee's Resume data deleted")
	})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id, Model model)
	{
		try
		{
			employeeService.deleteEmployee(employeeService.getEmployeeById(id));
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Can not delete employee resume",HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
