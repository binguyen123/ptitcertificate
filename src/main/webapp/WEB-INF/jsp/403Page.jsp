<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PTiT Certificate System</title>
<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap-united.css" rel="stylesheet" />

</head>
<body>
	<script src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.3.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>

	<jsp:include page="_barmenu.jsp"/>

	<h3 style="color: red;">${message}</h3>
</body>
</html>