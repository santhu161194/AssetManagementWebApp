<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#frame{
float:left;
clear:both;
position:relative;
left:200px;
bottom:300px;
}

</style>
</head>
<body>
<j:choose>
<j:when test="${not empty sessionScope.username}">





<div class="container">
	<h2 align="center">Asset Management</h2>
	<j:out  value=" ${status}"></j:out>
	<j:if test="${status}.equals(null)">
		<jsp:forward page="login"></jsp:forward>
	</j:if>
	 <!-- style="width: 30%"> -->
	<div style="border: 1px double; padding: 10px; width: 60%; margin: auto;">
		<h3 align="center">Home Page</h3>
		<h4><font color="green"> Welcome <%=session.getAttribute("username") %></font></h4>
		<br>
		
		<div style="margin-left:350px;">
			<div align="left"> <a href="viewAssets">View Departments</a></div><br>
			<div align="left"><a href="viewEmpls" >View Employee</a></div><br>
			

			<div align="left"><a href="addAsset">Add Asset</a></div><br>

			<div align="left"><a href=addAsset?adminId=${userid} >Add Asset</a></div><br>
			<div align="left"><a href="viewAssets" >View Assets</a></div><br>
			<div align="left"><a href=ViewAssetRequests?userId=${userid} >View Asset Requests</a></div><br>
			<div align="left"><a href="ViewAssetRequests1?status=A" >View Available Assets</a></div><br>
			<div align="left"><a href="addRoleToEmp" >Add Role To Employee</a></div><br>

			<div align="left"><a href="empl">Add Employee</a></div><br>

			<div align="left"><a href="viewAssets" >View Assets</a></div><br>
			<div align="left"><a href="viewAssetsByStatus?status=A" >View Available Assets</a></div><br>
			<div align="left"><a href="viewAssetsByStatus?status=N" >View UnAvailable Assets</a></div><br>
			
			
			<div align="left"><a href="allocateAsset?allocatedBy=${userid}">allocateAsset</a></div><br>
			<div align="left"><a href="deallocateAsset?deallocatedBy=${userid}">DellocateAsset</a></div><br>
			
			<div align="left"><a href="resetPassword?resetBy=${userid}">Reset Password</a></div><br>
			
			
			<div align="left"><a href="empl">Add Employee</a></div><br>
			
			<div align="left"><a href="ViewAssetRequests" >View Asset Requests</a></div><br>
			
			

			<div align="left"><a href=getSingleEmployee >Get Single Employee</a></div><br>

			<div align="left"><a href="invalidate">Logout</a></div><br>
			
		</div>
		
		 
		


	</div>
<!-- <iframe id="frame" src="viewDept" align="right" width="1000px" height="700px"></iframe> --> 
	</div>
	</j:when>
	<j:otherwise>
<a href="#">Click here to login</a>
</j:otherwise>
</j:choose>
</body>
</html>
