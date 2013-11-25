package com.meygam.actions;

import org.apache.struts2.convention.annotation.Action;

import com.meygam.controller.StudentController;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

public class LoginAction extends ActionSupport {

	private StudentController studentController;
	private String pageName;
	private String result;
	private String userName;
	private String password;

	@Action("login-input")
	public String input() throws Exception {
		return "login";
	}
	
	@Action("login")
	public String execute() throws Exception {
		studentController = new StudentController();
		
		if(pageName != null) {
			if(pageName.equals("login")) {			
				result = studentController.verifyStudent(userName, password);		
				if (result.equals("LoginFailure")) {
					return "failure";
				} else {
					return "success";
				}
			}			
		}
		return SUCCESS;
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


}
