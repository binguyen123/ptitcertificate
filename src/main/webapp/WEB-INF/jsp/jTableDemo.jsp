<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Failure</title>
<link href="resources/assets/css/bootstrap-united.css" rel="stylesheet" />
<link href="resources/DataTables/datatables.min.css" rel="stylesheet" />

<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" />
<link href="https://cdn.datatables.net/1.10.20/css/dataTables.jqueryui.min.css" rel="stylesheet" />

<script src="resources/jquery-1.8.3.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/bootstrap.js" type="text/javascript"> </script>
<!-- Include jTable script file. -->
<script src="resources/DataTables/datatables.min.js" type="text/javascript"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" type="text/javascript"></script>

</head>

<body>
	
	<script type="text/javascript">
	    $(document).ready(function () {
	        //Prepare jtable plugin
	        $("#dataTable").DataTable({
	            title: 'Student List',
	            searching: true,
	            ajax: "/Application/jtablejson",
	            "columns": [
	                { "data": "personId" },
	                { "data": "name" }
	            ]
	        });
	    });
	    
	</script>

	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/_barmenu.jspsp" />

	<!-- 
	<legend>Student Enrollment Login Success</legend>
	 -->
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3 class="panel-title">Student Enrollment Login failure</h3>
		</div>
		<div class="panel-body">
			<div class="alert alert-dismissable alert-danger">
				<table id="dataTable" class="display">
				    <thead>
				        <tr>
				            <th>ID</th>
				            <th>name </th>
				        </tr>
				    </thead>
				    <tbody>
				        <tr>
				            <td></td>
				            <td></td>
				        </tr>
				    </tbody>
				</table>
			</div>
		</div>
	</div>
	<div></div>
	<div></div>
	<a class="btn btn-primary" href="<spring:url value="login.html"/>">Try again?</a>
</body>
</html>