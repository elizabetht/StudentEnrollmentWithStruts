<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Enrollment Signup</title>
</head>
<body>
	<h1>New User Signup</h1>
	<s:form action="signup" validate="true">
		<s:hidden name="pageName" value="signup" />
		<s:textfield label="User Name" name="userName" />
		<s:password label="Password" name="password" />
		<s:textfield label="First Name" name="firstName" />
		<s:textfield label="Last Name" name="lastName" />
		<s:textfield label="Date of Birth(MM/dd/yyyy)" name="dateOfBirth" />		
		<s:textfield label="Email Address" name="emailAddress" />
		<s:submit value="Signup" />		
	</s:form>
	
	<h4>Already an user?<a href="<s:url action="login-input" />">Login</a></h4>
</body>
</html>