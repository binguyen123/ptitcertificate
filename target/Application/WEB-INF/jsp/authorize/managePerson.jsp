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

<title>Manage Student</title>
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
							action="${pageContext.request.contextPath}/person/add"
							class="bs-example form-horizontal" modelAttribute="person">
							<fieldset>
								<legend>Student</legend>

								<div class="form-group">
									<label for="firstName" class="col-lg-3 control-label">First
										Name:</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="firstName"
											name="firstName" id="firstName" placeholder="First Name" />
										<form:errors path="firstName" name="firstName"
											cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="lastName" class="col-lg-3 control-label">Last
										Name:</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="lastName"
											name="lastName" id="lastName" placeholder="Last Name" />
										<form:errors path="lastName" name="lastName" cssClass="error" />
									</div>
								</div>

								<div class="form-group row">
									<label for="dateOfBirth" class="col-lg-3 control-label">DOB:
									</label>
									<div class="col-lg-9">
										<form:input type="text" id="dateOfBirth" name="dateOfBirth"
											path="dateOfBirth" class="form-control" />
										<form:errors path="dateOfBirth" name="dateOfBirth"
											cssClass="error" />
									</div>
								</div>

								<div class="form-group row">
									<label for="gender" class="col-lg-3 control-label">Gender:
									</label>
									<div class="col-lg-9">
										<form:radiobutton path="gender" id="gender" name="gender"
											value="MALE" />
										- Male
										<form:radiobutton path="gender" id="gender" name="gender"
											value="FEMALE" />
										- Female
									</div>
								</div>

								<div class="form-group row">
									<label for="mobileNumber" class="col-lg-3 control-label">Mobile
										Number: </label>
									<div class="col-lg-9">
										<form:input type="text" id="mobileNumber" name="mobileNumber"
											path="mobileNumber" class="form-control"
											placeholder="Mobile Number" />
										<form:errors path="mobileNumber" name="mobileNumber"
											cssClass="error" />
									</div>
								</div>

								<div class="form-group row">
									<label for="email" class="col-lg-3 control-label">Email:
									</label>
									<div class="col-lg-9">
										<form:input type="email" id="email" name="email" path="email"
											class="form-control" placeholder="Email" />
										<form:errors path="email" name="email" cssClass="error" />
									</div>
								</div>
								<div class="form-group row">
									<label for="course_id" class="col-lg-3 control-label">Course:</label>
									<div class="col-lg-9">
										<form:select name="course_id" id="course_id" path="course_id">
											<c:forEach items="${listCourses}" var="course">
												<form:option value="${course.id}">${course.id} - ${course.name}</form:option>
											</c:forEach>
										</form:select>
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
		<table class="tg" id="tablePerson">
			<thead>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>D.O.B</th>
					<th>Gender</th>
					<th>Mobile</th>
					<th>Emails</th>
					<th>Course</th>
					<th>Edit / Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listPersons}" var="person">
					<tr>
						<td>${person.id}</td>
						<td>${person.firstName}</td>
						<td>${person.lastName}</td>
						<td>${person.dateOfBirth}</td>
						<td>${person.gender}</td>
						<td>${person.mobileNumber}</td>
						<td>${person.email}</td>
						<td>${person.course.name}</td>
						<td><a href="<c:url value='/person/edit/${person.id}' />">Edit</a>
							/ <a href="<c:url value='/person/remove/${person.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#tablePerson').DataTable();
		});

		$(function() {
			$('#dateOfBirth').datepicker();
		});
	</script>

</body>
</html>

