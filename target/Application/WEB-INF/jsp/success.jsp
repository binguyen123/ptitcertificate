<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
<link href="resources/assets/css/bootstrap-united.css" rel="stylesheet" />

</head>
<body>
	<script src="resources/jquery-1.8.3.js">
		
	</script>

	<script src="resources/bootstrap/js/bootstrap.js">
		
	</script>

	<jsp:include page="_barmenu.jsp" />

	<!-- 
	<legend>Student Enrollment Login Success</legend>
	 -->
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				Wellcome to PTiT Certificate System,
				<sec:authentication property="principal.username" />
			</h3>
		</div>
		<div class="panel-body">
			<div class="alert alert-dismissable alert-success">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<strong>Well done!</strong> You successfully logged-into the system
				and was granted
				<sec:authorize access="hasRole('ROLE_ADMIN')">Adminitrator</sec:authorize>
				<sec:authorize access="hasRole('ROLE_USER')">User</sec:authorize>
				 permission.
			
			</div>
		</div>
	</div>
	<div></div>
	<div></div>
	<a class="btn btn-primary" href="<spring:url value="/logout"/>">Login
		as different user?</a>
</body>
</html>