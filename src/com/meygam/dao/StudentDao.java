package com.meygam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.meygam.util.DbUtil;

public class StudentDao {
	private Connection dbConnection;
	
	public StudentDao() {
		dbConnection = DbUtil.getConnection();
	}
	
	public void addStudent(String userName, String password, String firstName, String lastName, String dateOfBirth, String emailAddress) {
		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("insert into student(userName, password, firstName, lastName, dateOfBirth, emailAddress) values (?, ?, ?, ?, ?, ?)");
			prepStatement.setString(1, userName);
			prepStatement.setString(2, password);
			prepStatement.setString(3, firstName);
			prepStatement.setString(4, lastName);
			
			try{
				Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfBirth);
				prepStatement.setDate(5, (java.sql.Date) new Date(dob.getTime()));
			} catch (ParseException e) {			
				e.printStackTrace();
			}	
			
			prepStatement.setString(6, emailAddress);
			
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkUserName(String userName) {
		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("select count(*) from student where userName = ?");
			prepStatement.setString(1, userName);	
						
			ResultSet result = prepStatement.executeQuery();
			if (result != null) {	
				while (result.next()) {
					if (result.getInt(1) == 1) {
						return true;
					}				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyStudent(String userName, String password) {
		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("select password from student where userName = ?");
			prepStatement.setString(1, userName);			
			
			ResultSet result = prepStatement.executeQuery();
			if (result != null) {
				while (result.next()) {
					if (result.getString(1).equals(password)) {
						return true;
					}
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
