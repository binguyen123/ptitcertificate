<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update User Information</title>
    <jsp:include page="../_extension.jsp"/>
    
</head>
<body>
<jsp:include page="../_barmenu.jsp"/>
<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">

                    <form:form id="myForm" method="POST"
                               action="${pageContext.request.contextPath}/editProfile"
                               class="bs-example form-horizontal" modelAttribute="profile">

                        <%-- Input First Name--%>
                        <div class="form-group">
                            <label for="firstName" class="col-lg-3 control-label">First
                                Name</label>
                            <div class="col-lg-9">
                                <form:input type="text" class="form-control"
                                            path="firstName" id="firstName"
                                            placeholder="First Name" name="firstName"/>
                                <form:errors path="firstName" cssClass="error"/>
                            </div>
                        </div>

                        <%--Input Last Name--%>
                        <div class="form-group">
                            <label for="lastName" class="col-lg-3 control-label">Last
                                Name</label>
                            <div class="col-lg-9">
                                <form:input type="text" class="form-control"
                                            path="lastName" id="lastName"
                                            placeholder="Last Name" name="lastName"/>
                                <form:errors path="lastName" cssClass="error"/>
                            </div>
                        </div>

                        <%-- Input Mobile Number--%>
                        <div class="form-group">
                            <label for="mobileNumber" class="col-lg-3 control-label">Mobile </label>
                            <div class="col-lg-9">
                                <form:input type="text" class="form-control"
                                            path="mobileNumber" id="mobileNumber"
                                            placeholder="Mobile Number" name="mobileNumber"/>
                                <form:errors path="mobileNumber" cssClass="error"/>
                            </div>
                        </div>

<%--                        &lt;%&ndash; Input Date Of Birth&ndash;%&gt;--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="mobileNumber" class="col-lg-3 control-label">Mobile </label>--%>
<%--                            <div class="col-lg-9">--%>
<%--                                <form:input type="date" class="form-control"--%>
<%--                                            path="dateOfBirth" id="dateOfBirth"--%>
<%--                                            placeholder="Date Of Birth" name="dateOfBirth"--%>
<%--                                            value="2022-11-20"/>--%>
<%--                                <form:errors path="dateOfBirth" cssClass="error"/>--%>
<%--                            </div>--%>
<%--                        </div>--%>

                        <div class="col-lg-9 col-lg-offset-3">
                            <button class="btn btn-primary">Update</button>
                            <button class="btn btn-default" type="button">Cancel</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        $('#dateOfBirthInput').datepicker();
    });

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
