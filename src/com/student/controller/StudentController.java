package com.student.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;

import com.student.dao.StudentDao;
import com.student.model.Student;

public class StudentController {

	private StudentDao studentDao;
	private Student student;
	
	public StudentController() {		
		student = new Student();
		studentDao = new StudentDao();
	}

	public String addStudent(String userName, String password, String firstName,
			String lastName, String dateOfBirth, String emailAddress) {
		
		if(student != null) {
			student.setUserName(userName);
			
			if (studentDao.checkUserName(userName)) {
				return "SignupFailure-UserNameExists";				
			}
			student.setPassword(password);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setEmailAddress(emailAddress);
		
			try {
				Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfBirth);
				student.setDateOfBirth(dob);
			} catch (ParseException e) {			
				e.printStackTrace();
			}		
			studentDao.addStudent(student);						
		}
		return "SignupSuccess";
	}

	public String verifyStudent(String userName, String password) {
		String result = "";
		boolean status = studentDao.verifyStudent(userName, password);
		if(status) {
			result = "LoginSuccess";
		} else {
			result = "LoginFailure";
		}
		return result;
	}
}
