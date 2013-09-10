<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Enrollment Login</title>
</head>
<body>
	<h1>Existing User Login</h1>
	<s:form action="login">
		<s:hidden name="pageName" value="login" />
		<s:textfield label="User Name" name="userName" />
		<s:password label="Password" name="password" />
		<s:submit value="Login" />
	</s:form>
</body>
</html>