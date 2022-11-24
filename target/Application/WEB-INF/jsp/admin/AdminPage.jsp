<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adminitration Homepage</title>
<link href="resources/assets/css/bootstrap-united.css" rel="stylesheet" />

</head>
<body>
	<script src="resources/jquery-1.8.3.js">
		
	</script>

	<script src="resources/bootstrap/js/bootstrap.js">
		
	</script>

	<jsp:include page="../bar_menu.jsp"/>
 
    <h2>Admin Page</h2>
 
 
    <h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
 
    <b>This is protected page!</b>  
</body>
</html>