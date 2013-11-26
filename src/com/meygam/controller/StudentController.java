package com.meygam.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;

import com.meygam.dao.StudentDao;
import com.meygam.model.Student;

public class StudentController {

	private StudentDao studentDao;
	private Student student;
	
	public StudentController() {		
		student = new Student();
		studentDao = new StudentDao();
	}

	public String addStudent(String userName, String password, String firstName,
			String lastName, String dateOfBirth, String emailAddress) {
		if(studentDao != null) {
			if (studentDao.checkUserName(userName)) {
				return "SignupFailure-UserNameExists";
			}
			
			studentDao.addStudent(userName, password, firstName, lastName, dateOfBirth, emailAddress);
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
