<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course In Subject</title>
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
		<table class="tg" id="tableCourse">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>AVG Point</th>
					<th>Certificate</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Subject</th>
					<th>Student</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listCourses}" var="course">
					<tr>
						<td>${course.id}</td>
						<td>${course.name}</td>
						<td>${course.pointAverage}</td>
						<td>${course.certificate.id}- ${course.certificate.name}</td>
						<td>${course.dateStart}</td>
						<td>${course.dateEnd}</td>
						<td><a
							href="<c:url value='/course/listSubject/${course.id}' />">Show</a></td>
						<td><a
							href="<c:url value='/course/listStudent/${course.id}' />">Show</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tableCourse').DataTable();
		});
	</script>
</body>
</html>