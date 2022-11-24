<%--
  Created by IntelliJ IDEA.
  User: baonguyen
  Date: 24/11/2022
  Time: 00:35
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:set var="ctxRoot" value="${pageContext.request.contextPath}"/>
    <title>Upload Content Frame Love</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="${ctxRoot}/resources/DataTables/datatables.min.css"/>

    <jsp:include page="../_extension.jsp"/>

</head>
<body>
<jsp:include page="../bar_menu.jsp"/>
</body>
</html>