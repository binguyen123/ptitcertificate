<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login Failure</title>
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap-united.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
</head>
<body>


<jsp:include page="_barmenu.jsp"/>

<!--
<legend>Student Enrollment Login Success</legend>
 -->
<div class="panel panel-danger">
    <div class="panel-heading">
        <h3 class="panel-title">Login Failed</h3>
    </div>
    <div class="panel-body">
        <div class="alert alert-dismissable alert-danger">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong>Oh snap!</strong> Something is wrong. Change a few things up
            and try submitting again.
        </div>
    </div>
</div>
<div></div>
<div></div>

<a class="btn btn-primary" href="<spring:url value="login.html"/>">Try
    again?</a>
</body>
</html>