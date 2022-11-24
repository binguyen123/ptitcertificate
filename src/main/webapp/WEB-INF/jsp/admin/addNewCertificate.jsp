<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CRUD Certificate</title>
    <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link href="resources/datepicker/css/datepicker.css" rel="stylesheet"/>
    <link href="resources/assets/css/bootstrap-united.css" rel="stylesheet"/>

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

<script src="resources/jquery-1.8.3.js">

</script>

<script src="resources/bootstrap/js/bootstrap.js">

</script>

<script src="resources/datepicker/js/bootstrap-datepicker.js">

</script>


<div class="container">
    <div class="jumbotron">
        <div>
            <h1 class="text-center">Certificate Manage Page</h1>
        </div>
    </div>

    <div></div>
</div>

<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <form:form id="myForm" method="post"
                               class="bs-example form-horizontal" modelAttribute="certificate">
                        <fieldset>
                            <legend>Create New Certificate</legend>

                            <div class="form-group">
                                <label for="name" class="col-lg-3 control-label">Certificate name:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control" path="name" id="name"/>
                                    <form:errors path="name" name="name" cssClass="error"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="description" class="col-lg-3 control-label">Certificate Description:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control"
                                                path="description" name="description" id="description"
                                                placeholder="Password"/>
                                    <form:errors path="description" name="description" cssClass="error"/>
                                </div>
                            </div>

                            <div class="col-lg-9 col-lg-offset-3">

                                <button class="btn btn-primary" data-toggle="modal"
                                        data-target="#themodal">Submit
                                </button>
                                <button class="btn btn-default">Cancel</button>

                                <div id="themodal" class="modal fade" data-backdrop="static">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-hidden="true">&times;
                                                </button>
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
</script>


</body>
</html>