<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap-united.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"
            type="text/javascript"></script>
    <style type="text/css">
        .error {
            color: #ff0000;
            font-size: 0.9em;
            font-weight: bold;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>

    <title>PTiT Certificate System</title>

</head>
<body>

<jsp:include page="_barmenu.jsp"/>

<div class="container">
    <div class="jumbotron">
        <div>
            <h1 class="text-center">PTiT Certificate System</h1>
        </div>
    </div>
</div>


<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <form:form id="myForm" method="post"
                               action="${pageContext.request.contextPath}/j_spring_security_check"
                               class="bs-example form-horizontal" modelAttribute="user">
                        <fieldset>
                            <legend>Login</legend>

                            <div class="form-group">
                                <label for="username" class="col-lg-3 control-label">User
                                    Name</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control" path="username"
                                                id="username" placeholder="User Name" name="username"/>
                                    <form:errors path="username" cssClass="error"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="col-lg-3 control-label">Password</label>
                                <div class="col-lg-9">
                                    <form:input type="password" class="form-control"
                                                path="password" name="password" id="password"
                                                placeholder="Password"/>
                                    <form:errors path="password" cssClass="error"/>
                                </div>

                            </div>

                            <div class="col-lg-9 col-lg-offset-3">
                                <button class="btn btn-default" type="button">Cancel</button>
                                <button class="btn btn-primary">Login</button>
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