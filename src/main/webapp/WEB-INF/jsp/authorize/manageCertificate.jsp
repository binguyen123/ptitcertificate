<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<title>Manage Certificate</title>
<style>
.green {
	font-weight: bold;
	color: green;
}

.message {
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

a
        .errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<jsp:include page="../_barmenu.jsp" />

	<%--if have error show message dialog--%>
	<c:if test="${not empty message}">
		<div class="container">
			<div class="alert alert-danger">${message}</div>
		</div>
	</c:if>
	<sec:authorize access="isAuthenticated()">
		<div class="col-lg-6 col-lg-offset-3">
			<div class="well">
				<div class="container">
					<div class="row">
						<div class="col-lg-6">

							<form:form id="myForm" method="POST"
								action="${pageContext.request.contextPath}/certificate/add"
								class="bs-example form-horizontal" modelAttribute="certificate">
								<fieldset>
									<legend>Certificate</legend>

									<div class="form-group">
										<label for="id" class="col-lg-3 control-label">ID:</label>
										<div class="col-lg-9">
											<form:input type="text" class="form-control" path="id"
												name="id" id="id" placeholder="Certificate Id"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57" />
											<form:errors path="id" name="id" cssClass="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="nameInput" class="col-lg-3 control-label">Name:</label>
										<div class="col-lg-9">
											<form:input type="text" class="form-control" path="name"
												name="name" id="nameInput" placeholder="Certificate Name" />
											<form:errors path="name" name="name" cssClass="error" />
										</div>
									</div>

									<div class="form-group row">
										<label for="grantedBy" class="col-lg-3 control-label">Course:</label>
										<div class="col-lg-9">
											<form:select name="grantedBy" id="grantedBy" path="grantedBy"
												class="form-control">
												<form:option value="">-- select program --</form:option>
												<c:forEach items="${listProgram}" var="pr">
													<form:option value="${pr.id}">${pr.id} - ${pr.name}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>

									<div class="form-group row">
										<label for="decriptionInput" class="col-lg-3 control-label">Description:</label>
										<div class="col-lg-9">
											<form:textarea id="decriptionInput" name="message"
												path="description" class="form-control"
												placeholder="Certificate Decription" rows="5" />
											<form:errors path="description" name="description"
												cssClass="error" />
										</div>
									</div>

									<div class="col-lg-9 col-lg-offset-3">

										<input class="btn btn-primary" style='margin-top: 20px;'
											type="submit" value="Confirm" id='jqxSubmitButton' /> <input
											class="btn btn-default" style='margin-top: 20px;'
											type="button" value="cancel" id='jqxButton' />

									</div>
								</fieldset>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</sec:authorize>
	<br>
	<div style="padding: 1%">
		<table class="tg" id="tableCertificate">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>List Course</th>
					<th>Grated By</th>
					<sec:authorize access="isAuthenticated()">
						<th>Edit / Delete</th>
					</sec:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listCertificates}" var="cer">
					<tr>
						<td>${cer.id}</td>
						<td>${cer.name}</td>
						<td>${cer.description}</td>
						<td><a
							href="<c:url value='/certificate/listCourse/${cer.id}' />">Show</a></td>
						<td>${cer.program.id}- ${cer.program.name}</td>
						<sec:authorize access="isAuthenticated()">
							<td><a href="<c:url value='/certificate/edit/${cer.id}' />">Edit</a>
								/ <a href="<c:url value='/certificate/remove/${cer.id}' />">Delete</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#tableCertificate').DataTable();
		});
	</script>

</body>
</html>
