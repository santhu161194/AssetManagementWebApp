<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table{
width:100%;
}
th, td {
    border-bottom: 1px solid #ddd;
    padding: 8px;
    text-align: center;
    vertical-align: center;
}
tr:nth-child(even) {background-color: #f2f2f2}
th {
    background-color: black;
    color: white;
}
</style>
<script>
  $(function() { // when DOM is ready
	    $(".showhide").click(function(){ 
	    	var toLoad=$(this).attr('id');// when #showhidecomment is clicked
	    	
	        $("#content").load(toLoad); // load the sample.jsp page in the #chkcomments element
	    }); 
	});
  </script>
</head>
<body>
<div id="content">

	<h2 id="id1" align="center">ASSET DATA</h2>

	<div id="id2">
		<h3 align="center">View Asset Requests</h3>
		</div>
	<h4><j:out value="${updatestatus}"></j:out></h4>
	<table border="2">
		<tr>
			<th> EmployeeId
			
			<th>assetType
			
			<th>requestDate
			
			<th>
			
		</tr>
		
		<j:forEach var="assetReq" items="${assetRequests}">
			<tr>
				<td><j:out value="${assetReq.employeeId} "></j:out></td>
				<td><j:out value="${assetReq.assetType} "></j:out></td>
				<td><j:out value="${assetReq.requestDate} "></j:out></td>
				<td><a id="viewAssetsByType?type=<j:out value="${assetReq.assetType}"></j:out>?RequestedBy=<j:out value="${assetReq.employeeId}"></j:out>" class="showhide" >Allocate</a></td>
				
				</tr>
				</j:forEach>
				</table>
				
				<a href="home">Return to home</a>
	
				</div>
</body>
</html>
				
	