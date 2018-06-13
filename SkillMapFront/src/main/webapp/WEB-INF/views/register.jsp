<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="springForm" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registeration</title>
</head>
<body>

<c:url var="add" value="saveregister"></c:url> 
		<h1 style="text-align: center">Welcome to Registration Page</h1>
		<br>
		<springForm:form action="${add}" modelAttribute="employee">
	<table>

	<tr>
		<td><springForm:label  path="employeeId">EmployeeId:</springForm:label> </td>
		<td><springForm:input  path="employeeId"/></td>
	</tr>
	<tr>
		<td><springForm:label  path="name">Name:</springForm:label> </td>
		<td><springForm:input  path="name" placeholder="Enter your name" /></td>
	</tr>
	<tr>
		<td><springForm:label  path="password">password:</springForm:label> </td>
		<td><springForm:password  path="password" placeholder="Enter your password" /></td>
	</tr>
	<tr>
		<td><springForm:label  path="dob">Enter DOB:</springForm:label> </td>
		<td><springForm:input  path="dob" placeholder="Enter your DOB" /></td>
	</tr>
	<tr>
		<td><springForm:label  path="email">Email:</springForm:label> </td>
		<td><springForm:input  path="email" placeholder="Enter your email" /></td>
	</tr>
	<tr>
		<td><springForm:label  path="doj">DOJ:</springForm:label> </td>
		<td><springForm:input  path="doj" placeholder="Enter your date of join" /></td>
	</tr>
	<tr>
		<td><springForm:label  path="mobile">Phone:</springForm:label> </td>
		<td><springForm:input  path="mobile" placeholder="Enter your mobile number" /></td>
	</tr>
	<tr>
		<td><springForm:label  path="qualification">Qualification:</springForm:label> </td>
		<td><springForm:input  path="qualification" placeholder="Enter your qualification" /></td>
	</tr>
	<tr>
		<td><springForm:label  path="gender">gender:</springForm:label> </td>
		<td><springForm:input  path="gender" placeholder="Enter your gender" /></td>
	</tr>
	<tr>
		<td><springForm:label  path="role">Role:</springForm:label> </td>
		<td><springForm:input  path="role" placeholder="Enter your role" /></td>
	</tr>
	<tr>
		<td><springForm:label  path="address">Address:</springForm:label> </td>
		<td><springForm:input  path="address" placeholder="Enter your address" /></td>
	</tr>
	<c:if test="${check}">
	<tr>
		<td colspan="2"><input type="submit" name=add value="save Employee" /></td>
		
	</tr>
	</c:if>
	<c:if test="${!check}">
	<tr>
		<td colspan="2"><input type="submit" name=update value="update Employee" /></td>
		
	</tr>
	</c:if>
	</table>
</springForm:form> 
					
<h3>Employees List</h3>
<c:if test="${!empty employees}">
	<table class="tg">
	<tr>
		<th>Employee ID</th>
		<th>Employee Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Qualification</th>
		<th>Role</th>
		<th>Address</th>
		<th>Gender</th>
		<th>DOB</th>
		<th>DOJ</th>
		
	</tr>
	<c:forEach items="${employees}" var="employee">
		<tr>
			<td>${employee.employeeId}</td>
			<td>${employee.name}</td>
			<td>${employee.email}</td>
			<td>${employee.mobile}</td>
			<td>${employee.qualification}</td>
			<td>${employee.role}</td>
			<td>${employee.address}</td>
			<td>${employee.gender}</td>
			<td>${employee.doj}</td>
			<td><a href="<c:url value='edit?employeeId=${employee.employeeId}' />" >Edit</a></td>
			<td><a href="<c:url value='remove/${employee.employeeId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
	 	