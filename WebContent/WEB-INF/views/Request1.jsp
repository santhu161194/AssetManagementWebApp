<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function ChooseContact(data) {

	document.getElementById ("friendName").value = data.value;

	}

</script>
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
<s:form commandName="postAssetRequests" action="postAssetRequests" method="post">
<h2 id="id1" align="center"> Confirm Asset-Request</h2>

	<div id="id2">
		<h3 align="center">${msg}</h3>
		</div>

<table align="center">

<tr><td>employeeId</td><td><input type="text" name="EmployeeId" value=${username} readonly></td></tr>
<%-- <tr><td>Asset Type</td><td><input type="text" name="assetType"  value=<%= request.getParameter("type") %> readonly></td></tr> --%>
<tr>
<td>
<select name="type" onchange="ChooseContact(this)">
  <option value="Laptop" name="type">Laptop</option>
  <option value="Desktop" name="type">Desktop</option>
  <option value="Mouse" name="type">Mouse</option>
  <option value="Keyboard" name="type">Keyboard</option>
</select>
</td>
<!-- <td><input id="friendName" type="text" name="type"></td> -->


</tr>

<tr><td></td><td><input type="submit" value="Confirm Request" class="showhide"></td><td></td></tr>
</table>
<a href="postAssetRequests" >Return to home</a>
</s:form>


</div>
</body>
</html>