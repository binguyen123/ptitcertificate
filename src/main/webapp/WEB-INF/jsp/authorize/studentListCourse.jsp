<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students In Course</title>
<jsp:include page="../_extension.jsp" />

<%-- jqwidget library --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jqwidgets/jqxradiobutton.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jqwidgets/jqxbuttons.js"></script>

<%-- jQuery Datatable--%>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"
	charset="UTF-8"></script>
</head>
<body>
	<div style="padding: 1%">
		<table class="tg" id="tablePerson1">
			<thead>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>D.O.B</th>
					<th>Gender</th>
					<th>Mobile</th>
					<th>Emails</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listStudent}" var="s">
					<tr>
						<td>${s.id}</td>
						<td>${s.firstName}</td>
						<td>${s.lastName}</td>
						<td>${s.dateOfBirth}</td>
						<td>${s.gender}</td>
						<td>${s.mobileNumber}</td>
						<td>${s.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#tablePerson1').DataTable();
		});
	</script>
</body>
</html>