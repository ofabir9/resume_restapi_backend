package com.abir.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abir.dto.UserLoginDTO;
import com.abir.dto.UserRegistrationDTO;
import com.abir.dto_to_model_converter.DTOToModelConverter;
import com.abir.model.Employee;
import com.abir.service.EmployeeService;

import io.swagger.annotations.Api;
@RestController
@Api(value="Authentication API",tags="Api for employees Login and Registration")
@RequestMapping("/api/v1/auth")
public class UserAuthenticationController {

	private EmployeeService employeeService;
	
	@Autowired
	public UserAuthenticationController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registration(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO,BindingResult result, Model model)
	{
		
		if(result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			System.out.println(errors);
			Map<String,List<String>> map = new HashMap<>();
			map.put("errors", errors);
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		if(employeeService.getEmployeeByEmail(userRegistrationDTO.getEmail())!=null)
		{
			List<String> errors = new ArrayList<>();
			errors.add("User Already exists with this email");
			System.out.println(errors);
			Map<String,List<String>> map = new HashMap<>();
			map.put("errors", errors);
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(employeeService.insertEmployee(DTOToModelConverter.userRegistrationDTOToEmployee(userRegistrationDTO)),HttpStatus.CREATED); 	
	}
	@PostMapping("/login")
	public ResponseEntity<?> registration(@Valid @RequestBody UserLoginDTO userLoginDTO,BindingResult result, Model model)
	{
		if(result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			System.out.println(errors);
			Map<String,List<String>> map = new HashMap<>();
			map.put("errors", errors);
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		Employee employee = employeeService.getEmployeeByEmail(userLoginDTO.getEmail());
		if(employee==null)
		{
			List<String> errors = new ArrayList<>();
			errors.add("User doesn't exists with this email");
			System.out.println(errors);
			Map<String,List<String>> map = new HashMap<>();
			map.put("errors", errors);
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		if(!employee.getPassword().equals(userLoginDTO.getPassword()))
		{
			List<String> errors = new ArrayList<>();
			errors.add("Password incorrect!");
			System.out.println(errors);
			Map<String,List<String>> map = new HashMap<>();
			map.put("errors", errors);
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(employee,HttpStatus.OK);	
		
	}
}
