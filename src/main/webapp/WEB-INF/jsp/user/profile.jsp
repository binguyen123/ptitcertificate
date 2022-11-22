<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update User Information</title>
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="resources/datepicker/css/datepicker.css" rel="stylesheet" />
<link href="resources/assets/css/bootstrap-united.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../bar_menu.jsp" />

	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<form:form id="myForm" method="POST"
							action="${pageContext.request.contextPath}/editProfile"
							class="bs-example form-horizontal" modelAttribute="profile">
							<div class="form-group">
								<label for="firstName" class="col-lg-3 control-label">First
									Name</label>
								<div class="col-lg-9">
									<form:input type="text" class="form-control"
										path="firstName" id="firstName"
										placeholder="First Name" name="firstName" />
									<form:errors path="firstName" cssClass="error" />
								</div>
							</div>
							<div class="form-group">
								<label for="lastName" class="col-lg-3 control-label">Last
									Name</label>
								<div class="col-lg-9">
									<form:input type="text" class="form-control"
										path="lastName" id="lastName"
										placeholder="Last Name" name="lastName" />
									<form:errors path="lastName" cssClass="error" />
								</div>
							</div>
							<div class="form-group">
								<label for="mobileNumber" class="col-lg-3 control-label">Mobile </label>
								<div class="col-lg-9">
									<form:input type="text" class="form-control"
										path="mobileNumber" id="mobileNumber"
										placeholder="Mobile Number" name="mobileNumber" />
									<form:errors path="mobileNumber" cssClass="error" />
								</div>
							</div>
							<div class="col-lg-9 col-lg-offset-3">
								<button class="btn btn-default" type="button">Cancel</button>
								<button class="btn btn-primary">Update</button>
							</div>
						</form:form> 
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
