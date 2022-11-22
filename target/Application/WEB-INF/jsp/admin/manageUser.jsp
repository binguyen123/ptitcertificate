<%--
  Created by IntelliJ IDEA.
  User: baonguyen
  Date: 19/11/2022
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Enrollment Signup</title>
    <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" />
    <link href="resources/datepicker/css/datepicker.css" rel="stylesheet" />
    <link href="resources/assets/css/bootstrap-united.css" rel="stylesheet" />

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

    <div class="col-lg-6 col-lg-offset-3">
        <div class="well">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <form:form id="myForm" method="post"
                                   class="bs-example form-horizontal" modelAttribute="manageuser">
                            <fieldset>
                                <legend>Manage User</legend>

                                <div class="form-group">
                                    <label for="userNameInput" class="col-lg-3 control-label">Username:</label>
                                    <div class="col-lg-9">
                                        <form:input type="text" class="form-control" path="username"
                                                    name="username" id="userNameInput" placeholder="User Name" />
                                        <form:errors path="username" name="username" cssClass="error" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="passwordInput" class="col-lg-3 control-label">Password:</label>
                                    <div class="col-lg-9">
                                        <form:input type="password" class="form-control"
                                                    path="password" name="password" id="passwordInput"
                                                    placeholder="Password" />
                                        <form:errors path="password" name="password" cssClass="error" />
                                    </div>
                                </div>

                                <div class="col-lg-9 col-lg-offset-3">

                                    <button class="btn btn-primary" data-toggle="modal"
                                            data-target="#themodal">Submit</button>
                                    <button class="btn btn-default">Cancel</button>

                                    <div id="themodal" class="modal fade" data-backdrop="static">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-hidden="true">&times;</button>
                                                    <h3>Signup Form Submission</h3>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Do you want create user account?</p>
                                                    <div class="progress progress-striped active">
                                                        <div id="doitprogress" class="progress-bar"></div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <input type="submit" value="Yes" id="yesbutton"
                                                           class="btn btn-primary" data-loading-text="Saving.."
                                                           data-complete-text="Saved!"> <a href="#"
                                                                                           class="btn btn-default" data-dismiss="modal">Cancel</a>
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
</body>
</html>
