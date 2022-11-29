<%--
  Created by IntelliJ IDEA.
  User: baonguyen
  Date: 29/11/2022
  Time: 01:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="../_extension.jsp"/>

    <%-- jqwidget library --%>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/jqwidgets/jqxradiobutton.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/jqwidgets/jqxbuttons.js"></script>

    <script src="${pageContext.request.contextPath}/resources/datepicker/js/bootstrap-datepicker.js"></script>

    <%-- jQuery Datatable--%>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"
            charset="UTF-8"></script>

    <title>Manage Program</title>
</head>
<body>
<jsp:include page="../_barmenu.jsp"/>

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
                               action="${pageContext.request.contextPath}/program/add"
                               class="bs-example form-horizontal" modelAttribute="program">
                        <fieldset>
                            <legend>Program</legend>

                            <div class="form-group">
                                <label for="nameInput" class="col-lg-3 control-label">Name:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control"
                                                path="name" name="name" id="nameInput"
                                                placeholder="Subject Name"/>
                                    <form:errors path="name" name="name" cssClass="error"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="descriptionInput" class="col-lg-3 control-label">Point Average:</label>
                                <div class="col-lg-9">
                                    <form:textarea id="descriptionInput" name="description" path="description"
                                                   class="form-control" placeholder="Subject Decription"/>
                                    <form:errors path="description" name="description" cssClass="error"/>
                                </div>
                            </div>

                            <div class="col-lg-9 col-lg-offset-3">

                                <input class="btn btn-primary" style='margin-top: 20px;' type="submit" value="Confirm"
                                       id='jqxSubmitButton'/>

                                <input class="btn btn-default" style='margin-top: 20px;' type="button" value="Cancel"
                                       id='jqxButton'/>

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
    <table class="tg" id="tableProgram">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Edit / Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listPrograms}" var="pro">
            <tr>
                <td>${pro.id}</td>
                <td>${pro.name}</td>
                <td>${pro.description}</td>
                <td><a href="<c:url value='/program/edit/${pro.id}' />">Edit</a> /
                    <a href="<c:url value='/program/remove/${pro.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#tableProgram').DataTable();
    });
    $(function () {
        $('#dateStart').datepicker();
    });
    $(function () {
        $('#dateEnd').datepicker();
    });
</script>

</body>
</html>
