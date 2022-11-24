<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <link href="resources/assets/css/bootstrap-united.css" rel="stylesheet"/>
    <link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="bar_menu.jsp"/>
<div class="container">
    <div class="jumbotron">

        <h1>PTiT Certificate System</h1>

        <c:if test="${!loginstatus}">
            <a class="btn btn-primary" href="login">Login >></a>
            <a class="btn btn-primary" href="editProfile">edit profile >></a>
        </c:if>
    </div>

</div>
<script src="resources/jquery-1.8.3.js">
</script>
<script src="resources/bootstrap/js/bootstrap.js">
</script>

</body>
</html>
