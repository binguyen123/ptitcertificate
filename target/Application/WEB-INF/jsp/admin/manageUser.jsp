<%--
  Created by IntelliJ IDEA.
  User: baonguyen
  Date: 19/11/2022
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Manage user</title>
    <jsp:include page="../_extension.jsp"/>

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
<jsp:include page="../bar_menu.jsp"/>
<div class="container">
    <div class="jumbotron">
        <div>
            <h1 class="text-center">Create New Account for User</h1>
        </div>
    </div>

    <div></div>
</div>

<c:if test="${not empty message}">
    <div class="message green">${message}</div>
</c:if>

<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">

                    <c:url var="addAction" value="/signupUser"/>

                    <form:form id="myForm" method="POST" action="${addAction}"
                               class="bs-example form-horizontal" modelAttribute="user">
                        <fieldset>
                            <legend>Register account</legend>

                            <div class="form-group">
                                <label for="userNameInput" class="col-lg-3 control-label">Username:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control" path="username"
                                                name="username" id="userNameInput" placeholder="User Name"/>
                                    <form:errors path="username" name="username" cssClass="error"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="passwordInput" class="col-lg-3 control-label">Password:</label>
                                <div class="col-lg-9">
                                    <form:input type="password" class="form-control"
                                                path="password" name="password" id="passwordInput"
                                                placeholder="Password"/>
                                    <form:errors path="password" name="password" cssClass="error"/>
                                </div>
                            </div>

                            <div class="col-lg-9 col-lg-offset-3">
                                <input type="button" class="btn btn-primary" value="Create User" onclick="changeAction(this)"/>
                                <input type="button" class="btn btn-primary" value="Create Admin" onclick="changeAction(this)"/>
                                <button class="btn btn-default">Cancel</button>

                                <div id="themodal" class="modal fade" data-backdrop="static">
                                    <div class="modal-dialog">
                                        <div class="modal-content">

                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-hidden="true">&times;
                                                </button>
                                                <h3>Create User?..</h3>
                                            </div>

                                            <div class="modal-body">
                                                <p>Do you want create new user?</p>
                                                <div class="progress progress-striped active">
                                                    <div id="doitprogress" class="progress-bar"></div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="submit" value="Yes" id="yesbutton"
                                                       class="btn btn-primary" data-loading-text="Saving.."
                                                       data-complete-text="Saved!"> <a href="#"
                                                                                       class="btn btn-default"
                                                                                       data-dismiss="modal">Cancel</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<br>
<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <h3>Persons List</h3>
                    <c:if test="${!empty listUsers}">
                        <table class="tg">
                            <tr>
                                <th width="80">ID</th>
                                <th width="120">User Name</th>
                                <th width="120">User Password (Bcryt Encode)</th>
                                <th width="60">Edit</th>
                                <th width="60">Delete</th>
                            </tr>
                            <c:forEach items="${listUsers}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.username}</td>
                                    <td>${user.password}</td>
                                    <td><a href="<c:url value='/edit/${user.id}' />">Edit</a></td>
                                    <td><a href="<c:url value='/remove/${user.id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        var yesButton = $("#yesbutton");
        var progress = $("#doitprogress");

        yesButton.click(function () {
            yesButton.button("loading");

            var counter = 0;
            var countDown = function () {
                counter++;
                if (counter == 11) {
                    yesButton.button("complete");
                } else {
                    progress.width(counter * 10 + "%");
                    setTimeout(countDown, 100);
                }
            };
            setTimeout(countDown, 100);
        });

    });

    function changeAction(a) {
        var formEle = document.getElementById('#myForm');
        if (a.value == "Create User")
            formEle.setAttribute("action", "/signupUser");
        else
            formEle.setAttribute("action", "/signupAdmin");
    }

</script>

</body>
</html>
