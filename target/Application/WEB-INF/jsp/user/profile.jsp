<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update PTiT Student Information</title>
    <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link href="resources/datepicker/css/datepicker.css" rel="stylesheet"/>
    <link href="resources/assets/css/bootstrap-united.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../bar_menu.jsp"/>

<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <form:form id="myForm" method="POST"
                               action="${pageContext.request.contextPath}/editProfile"
                               class="bs-example form-horizontal" modelAttribute="profile">
                        <fieldset>
                            <div class="form-group">
                                <label for="profileFirstName" class="col-lg-3 control-label">First
                                    Name</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control"
                                                path="profileFirstName" id="profileFirstName"
                                                placeholder="First Name" name="profileFirstName"/>
                                    <form:errors path="profileFirstName" cssClass="error"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profileLastName" class="col-lg-3 control-label">First
                                    Name</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control"
                                                path="profileLastName" id="profileLastName"
                                                placeholder="LastName Name" name="profileLastName"/>
                                    <form:errors path="profileLastName" cssClass="error"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profileMobileNumber" class="col-lg-3 control-label">First
                                    Name</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control"
                                                path="profileMobileNumber" id="profileMobileNumber"
                                                placeholder="Mobile Number" name="profileMobileNumber"/>
                                    <form:errors path="profileMobileNumber" cssClass="error"/>
                                </div>
                            </div>
                            <div class="col-lg-9 col-lg-offset-3">
                                <button class="btn btn-default" type="button">Cancel</button>
                                <button class="btn btn-primary">Register</button>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
