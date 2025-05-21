<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.controller.UserRegistrationCtl"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.UserBean"
		scope="request"></jsp:useBean>

	<%@ include file="Header.jsp"%>

	<form action="<%=ORSView.USER_REGISTRATION_CTL%>" method="post">
		<center>
			<span style="color: green"><%=ServletUtility.getSuccessMessage(request)%></span>

			<table>
				<tr>
					<th>First Name<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="firstName"
						placeholder="Enter Your First Name" size="26" value="<%=DataUtility.getStringData(bean.getFirstName())%>"><font
						color="red"><%=ServletUtility.getErrorMessage("firstName", request)%></font>
					</td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Last Name<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="lastName"
						placeholder="Enter Your Last Name" size="26" value="<%=DataUtility.getStringData(bean.getLastName())%>"><font
						color="red"><%=ServletUtility.getErrorMessage("lastName", request)%></font>
					</td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Login Id<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="login"
						placeholder="Enter Your Login Id" size="26" value="<%=DataUtility.getStringData(bean.getLogin())%>"><font
						color="red"><%=ServletUtility.getErrorMessage("login", request)%></font>
					</td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Gender<span style="color: red">*</span> :
					</th>
					<td>
						<%
						HashMap map = new HashMap();
						map.put("Male", "Male");
						map.put("Female", "Female");

						String htmlList = HTMLUtility.getList("gender", bean.getGender(), map);
						%><%=htmlList%> <font color="red"><%=ServletUtility.getErrorMessage("gender", request)%>
					</font>
					</td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Date Of Birth<span style="color: red">*</span> :
					</th>
					<td><input type="date" name="dob" size="26"
						placeholder="Enter Your Date Of Birth" value="<%=DataUtility.getDateString(bean.getDob())%>"><font
						color="red"><%=ServletUtility.getErrorMessage("dob", request)%>
					</font></td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Mobile No <span style="color: red">*</span> :
					</th>
					<td><input type="text" name="mobileNo"
						placeholder="Enter Your Mobile No." size="26" maxlength="10"
						value="<%=DataUtility.getStringData(bean.getMobileNo())%>"><font color="red"><%=ServletUtility.getErrorMessage("mobileNo", request)%></font></td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Password <span style="color: red">*</span> :
					</th>
					<td><input type="password" name="password"
						placeholder="Enter Your Password" size="26" value="<%=DataUtility.getStringData(bean.getPassword())%>"><font
						color="red"><%=ServletUtility.getErrorMessage("password", request)%></font></td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Confirm Password <span style="color: red">*</span> :
					</th>
					<td><input type="password" name="confirmPassword"
						placeholder="Re-Enter Your Password" size="26" value="<%=DataUtility.getStringData(bean.getConfirmPassword())%>"><font
						color="red"><%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th></th>
					<td colspan="2">&nbsp; &nbsp; <input type="submit"
						name="operation" value="<%=UserRegistrationCtl.OP_SIGN_UP%>">
						&nbsp; <input type="submit" name="operation"
						value="<%=UserRegistrationCtl.OP_RESET%>">
					</td>
				</tr>
			</table>
		</center>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>