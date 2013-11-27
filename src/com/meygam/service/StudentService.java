package com.meygam.service;

import com.meygam.repository.StudentRepository;

public class StudentService {

	private StudentRepository studentDao;

	public StudentService() {
		studentDao = new StudentRepository();
	}

	public String addStudent(String userName, String password,
			String firstName, String lastName, String dateOfBirth,
			String emailAddress) {
		if (studentDao != null) {
			if (studentDao.checkUserName(userName)) {
				return "SignupFailure-UserNameExists";
			}
			studentDao.addStudent(userName, password, firstName, lastName,
					dateOfBirth, emailAddress);
			return "SignupSuccess";
		} else {
			return "SignupFailure";
		}
	}

	public String verifyStudent(String userName, String password) {
		String result = "LoginFailure";
		if (studentDao != null) {
			boolean status = studentDao.verifyStudent(userName, password);
			if (status) {
				result = "LoginSuccess";
			}
		}
		return result;
	}
}
