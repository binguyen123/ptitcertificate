<%--
  Created by IntelliJ IDEA.
  User: baonguyen
  Date: 29/11/2022
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../_extension.jsp" />

<%-- jqwidget library --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jqwidgets/jqxradiobutton.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jqwidgets/jqxbuttons.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/datepicker/js/bootstrap-datepicker.js"></script>

<%-- jQuery Datatable--%>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"
	charset="UTF-8"></script>

<title>Manage Course</title>
</head>
<body>
	<jsp:include page="../_barmenu.jsp" />

	<%--if have error show message dialog--%>
	<c:if test="${not empty message}">
		<div class="message green">${message}</div>
	</c:if>

	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">

						<form:form id="myForm" method="POST"
							action="${pageContext.request.contextPath}/course/add"
							class="bs-example form-horizontal" modelAttribute="course">
							<fieldset>
								<legend>Course</legend>

								<div class="form-group">
									<label for="nameInput" class="col-lg-3 control-label">Name:</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="name"
											name="name" id="nameInput" placeholder="Subject Name" />
										<form:errors path="name" name="name" cssClass="error" />
									</div>
								</div>

								<div class="form-group row">
									<label for="pointAverage" class="col-lg-3 control-label">Point
										Average:</label>
									<div class="col-lg-9">
										<form:input type="text" id="pointAverage" name="pointAverage"
											path="pointAverage" class="form-control" />
										<form:errors path="pointAverage" name="pointAverage"
											cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="dateStart" class="col-lg-3 control-label">Start:</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="dateStart"
											name="dateStart" id="dateStart" />
										<form:errors path="name" name="name" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="dateEnd" class="col-lg-3 control-label">End:</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="dateEnd"
											name="dateEnd" id="dateEnd" />
										<form:errors path="dateEnd" name="dateEnd" cssClass="error" />
									</div>
								</div>

								<div class="col-lg-9 col-lg-offset-3">

									<input class="btn btn-primary" style='margin-top: 20px;'
										type="submit" value="Confirm" id='jqxSubmitButton' /> <input
										class="btn btn-default" style='margin-top: 20px;'
										type="button" value="Cancel" id='jqxButton' />

								</div>
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>
	<div style="padding: 1%">
		<table class="tg" id="tableCourse">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>AVG Point</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>List Student</th>
					<th>Edit / Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listCourses}" var="course">
					<tr>
						<td>${course.id}</td>
						<td>${course.name}</td>
						<td>${course.pointAverage}</td>
						<td>${course.dateStart}</td>
						<td>${course.dateEnd}</td>
						<td> <a href="<c:url value='/course/listStudent/${course.id}' />">Show</a></td>
						<td><a href="<c:url value='/course/edit/${course.id}' />">Edit</a>
							/ <a href="<c:url value='/course/remove/${course.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#tableCourse').DataTable();
		});
		$(function() {
			$('#dateStart').datepicker();
		});
		$(function() {
			$('#dateEnd').datepicker();
		});
	</script>

</body>
</html>
