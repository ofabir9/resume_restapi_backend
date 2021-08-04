package com.abir.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.abir.model.Employee;

public class EmployeeValidator {
	public static List<String> getErrors(Employee employee)
	{
		List<String>errors = new ArrayList<String>();
		
		StringTokenizer tokenizer = new StringTokenizer(employee.getFirstName(), " ");
        
        while (tokenizer.hasMoreElements()) {
        
        	String nameParts = tokenizer.nextToken();
        	if(!nameParts.matches("^[a-zA-Z]*$"))
        	{
        		errors.add("First Name should contain only character and spaces");
        	}
        }
        
        tokenizer = new StringTokenizer(employee.getLastName(), " ");
        
        while (tokenizer.hasMoreElements()) {
        
        	String nameParts = tokenizer.nextToken();
        	if(!nameParts.matches("^[a-zA-Z]*$"))
        	{
        		errors.add("Last Name should contain only character and spaces");
        	}
        }
        
        if(!employee.getMobile().matches("^[0-9]*$") || !(employee.getMobile().length() >= 11 && employee.getMobile().length() < 13))
        {
        	errors.add("Enter valid Mobile number");
        }
        if(!employee.getGithub().matches("(((http|https)://)(www.)?)?"
              + "[a-zA-Z0-9@:%._\\+~#?&//=]"
              + "{2,256}\\.[a-z]"
              + "{2,6}\\b([-a-zA-Z0-9@:%"
              + "._\\+~#?&//=]*)"))
	        {
	        	errors.add("Enter valid Github profile link");
	        }
        if(!employee.getLinkedin().matches("(((http|https)://)(www.)?)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)"))
          {
          	errors.add("Enter valid Linkedin profile link");
          }
       if(!employee.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
        {
          	errors.add("Enter valid Email");
          }
        if(employee.getAddress().length()<2 )
        {
        	errors.add("Enter valid Address");
        }
        
        return errors;
	}

}
