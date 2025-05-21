<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.UserBean"
		scope="request"></jsp:useBean>
		
	<%@ include file="Header.jsp"%>

	<h1 align="center">Login</h1>
	
	<form action="<%=ORSView.LOGIN_CTL%>" method="post">
		<center>

			<span style="color: red"><%=ServletUtility.getErrorMessage(request)%></span>
			<span style="color: green"><%=ServletUtility.getSuccessMessage(request)%></span>

			<table>
				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value="<%=DataUtility.getStringData(bean.getLogin()) %>"
						placeholder="Enter Your Email"><font color="red"><%=ServletUtility.getErrorMessage("login", request)%></font></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value="<%=DataUtility.getStringData(bean.getPassword()) %>"
						placeholder="Enter Your Password"><font color="red"><%=ServletUtility.getErrorMessage("password", request)%></font></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=LoginCtl.OP_SIGN_IN%>"> &nbsp;&nbsp; <input
						type="submit" name="operation" value="<%=LoginCtl.OP_SIGN_UP%>"></td>
				</tr>
			</table>
		</center>
	</form>

	<%@ include file="Footer.jsp"%>
</body>
</html>