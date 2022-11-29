<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap-united.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
</head>
<body>

<jsp:include page="_barmenu.jsp"/>

<div class="container">
    <div class="jumbotron">

        <h1>PTiT Certificate System Homepage</h1>

        <sec:authorize access="isAnonymous()">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/login">Login >></a>
        </sec:authorize>
    </div>

</div>
<script src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.3.js">
</script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js">
</script>

</body>
</html>
