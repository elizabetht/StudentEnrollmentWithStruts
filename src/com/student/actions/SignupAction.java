package com.student.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.student.controller.StudentController;

public class SignupAction extends ActionSupport {	

	private String pageName;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String emailAddress;	
	private StudentController studentController;
	private String result;

	@Action("signup-input")
	public String input() throws Exception {
		return "signup";
	}
	
	@Override	
	@Action(value="signup", results={@Result(name="login-input", location="login-input", type="redirect")})
	public String execute() throws Exception {
		
		studentController = new StudentController();
		
		if(pageName != null) {
			if(pageName.equals("signup")) {		
				result = studentController.addStudent(userName, password, firstName, lastName, dateOfBirth, emailAddress);	
				if (result.equals("SignupSuccess")) {
					return "login-input";
				} else {
					return "failure";
				}
			} 	
		}
		return SUCCESS;	
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getUserName() {
		return userName;
	}

	@RequiredStringValidator(type=ValidatorType.FIELD, message="UserName is a required field")
	@StringLengthFieldValidator(type=ValidatorType.FIELD, maxLength="12", minLength="6", message="UserName must be of length between 6 and 12" )
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	@RequiredStringValidator(type=ValidatorType.FIELD, message="Password is a required field")
	@StringLengthFieldValidator(type=ValidatorType.FIELD, maxLength="12", minLength="6", message="Password must be of length between 6 and 12" )
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	@RequiredStringValidator(type=ValidatorType.FIELD, message="FirstName is a required field")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@RequiredStringValidator(type=ValidatorType.FIELD, message="LastName is a required field")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@RequiredStringValidator(type=ValidatorType.FIELD, message="EmailAddress is a required field")
	@EmailValidator(type=ValidatorType.FIELD, message="Email Address must be valid")
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@RequiredStringValidator(type=ValidatorType.FIELD, message="DateOfBirth is a required field")	
	public void setDateOfBirth(String dateOfBirth) {				
		this.dateOfBirth = dateOfBirth;
	}	
}
