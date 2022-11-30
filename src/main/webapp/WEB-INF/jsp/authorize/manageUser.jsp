<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../_extension.jsp" />

<%-- jqwidget library --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jqwidgets/jqxradiobutton.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jqwidgets/jqxbuttons.js"></script>

<%-- jQuery Datatable--%>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"
	charset="UTF-8"></script>

<!-- 
    <script type="text/javascript">
        $(document)
            .ready(
                function () {
                    var ordersSource = {
                        dataFields: [{
                            name: 'id',
                            type: 'Long'
                        }, {
                            name: 'username',
                            type: 'String'
                        }, {
                            name: 'password',
                            type: 'String'
                        }],
                        type: "POST",
                        dataType: "json",
                        url: "${pageContext.request.contextPath}/getDataForTable",
                        pagesize: 20,
                        id: 'id',
                        addRow: function (rowID, rowData, position, commit) {
                            // synchronize with the server - send insert command
                            // call commit with parameter true if the synchronization with the server is successful
                            // and with parameter false if the synchronization failed.
                            // you can pass additional argument to the commit callback which represents the new ID if it is generated from a DB.
                            commit(true);
                        },
                        updateRow: function (rowID, rowData, commit) {
                            // synchronize with the server - send update command
                            // call commit with parameter true if the synchronization with the server is successful
                            // and with parameter false if the synchronization failed.
                            commit(true);
                        },
                        deleteRow: function (rowID, commit) {
                            // synchronize with the server - send delete command
                            // call commit with parameter true if the synchronization with the server is successful
                            // and with parameter false if the synchronization failed.
                            commit(true);
                        }
                    };
                    var dataAdapter = new $.jqx.dataAdapter(
                        ordersSource,
                        {
                            formatData: function (data) {
                                data["page"] = data["pagenum"];
                                data["limit"] = data["pagesize"];
                                return data;
                            },
                            downloadComplete: function (data, status,
                                                        xhr) {
                                if (!ordersSource.totalRecords) {
                                    ordersSource.totalRecords = data.totalRecords;
                                }
                            },
                            loadError: function (xhr, status, error) {
                                throw new Error(error);
                            }
                        });

                    var cellsrenderer = function (row, columnfield, value,
                                                  defaulthtml, columnproperties) {
                        return '<span style="margin: 4px;float: none;font-weight: bold">****</span>';
                    };

                    $("#table").jqxDataTable({
                        width: '100%',
                        pageSize: 3,
                        source: dataAdapter,
                        serverProcessing: true,
                        pageable: true,
                        editable: true,
                        showToolbar: true,
                        altRows: true,
                        editSettings: {
                            saveOnPageChange: true,
                            saveOnBlur: true,
                            saveOnSelectionChange: true,
                            cancelOnEsc: true,
                            saveOnEnter: true,
                            editSingleCell: true,
                            editOnDoubleClick: true,
                            editOnF2: true
                        },
                        columns: [{
                            text: 'ID',
                            editable: false,
                            dataField: 'id',
                            cellsAlign: 'centre',
                            align: 'right',
                            width: '10%'
                        }, {
                            text: 'UserName',
                            dataField: 'username',
                            cellsAlign: 'centre',
                            align: 'right',
                            editable: true,
                            width: '40%'
                        }, {
                            text: 'Password ',
                            dataField: 'password',
                            editable: true,
                            cellsAlign: 'centre',
                            cellsrenderer: cellsrenderer,
                            align: 'right'
                        }]
                    });

                    $("#table").on('cellBeginEdit', function (event) {
                        var args = event.args;
                        // row key
                        var rowKey = args.key;
                        // row's index.
                        var rowIndex = args.index;
                        // row's data.
                        var rowData = args.row;
                        // row's index in the data source.
                        var rowBoundIndex = args.boundIndex;
                        // column's data field.
                        var columnDataField = args.dataField;
                        // column's display field.
                        var columnDisplayField = args.displayField;
                        // cell's value.
                        var value = args.value;
                    });
                    // Cell End Edit
                    $("#table")
                        .on(
                            'cellEndEdit',
                            function (event) {
                                var args = event.args;
                                // row key
                                var rowKey = args.key;
                                // row's index.
                                var rowIndex = args.index;
                                // row's data.
                                var rowData = args.row;
                                // row's index in the data source.
                                var rowBoundIndex = args.boundIndex;
                                // column's data field.
                                var columnDataField = args.dataField;
                                // column's display field.
                                var columnDisplayField = args.displayField;
                                // cell's value.
                                var value = args.value;
                                var dataSummit = {
                                    "id": args.row["id"],
                                    "password": args.row["password"],
                                    "username": args.row["username"]
                                };
                                $
                                    .ajax({
                                        url: "${pageContext.request.contextPath}/updateDataForTable",
                                        type: "POST",
                                        data: JSON
                                            .stringify(dataSummit),
                                        contentType: "application/json",
                                        success: function (data) {
                                            alert(data);
                                        }
                                    });
                            });
                });
    </script>
-->

<title>Manage User</title>

</head>
<body>
	<jsp:include page="../_barmenu.jsp" />
	
	<%--if have error show message dialog--%>
	<c:if test="${not empty message}">
		<div class="container">
			<div class="alert alert-danger">${message}</div>
		</div>
	</c:if>
<sec:authorize access="isAuthenticated()">
	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">

						<form:form id="myForm" method="POST"
							action="${pageContext.request.contextPath}/user/add"
							class="bs-example form-horizontal" modelAttribute="user">

							<fieldset>
								<legend>User</legend>

								<div class="form-group">
									<label for="nameInput" class="col-lg-3 control-label">Username:</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="username"
											name="username" id="nameInput" placeholder="User Name" />
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
									<form:radiobutton path="role" value="ROLE_USER" name="role"
										id="role" />
									User
									<form:radiobutton path="role" value="ROLE_ADMIN" name="role"
										id="role" />
									Admin
								</div>

								<div class="col-lg-9 col-lg-offset-3">
									<input class="btn btn-primary" style='margin-top: 20px;'
										type="submit" value="Confirm" id='jqxSubmitButton' /> <input
										class="btn btn-default" style='margin-top: 20px;'
										type="button" value="cancel" id='jqxButton' />
								</div>
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</sec:authorize>


	<div class="col-lg-6 col-lg-offset-3">
		<div id="table"></div>
	</div>
	<div style="padding: 1%">
		<table class="tg" id="tableUser">
			<thead>
				<tr>
					<th>Id</th>
					<th>UserName</th>
					<th>Password</th>
					<sec:authorize access="isAuthenticated()"><th>Edit/Delete</th></sec:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUsers}" var="user">
					<tr id="${user.id}">
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<sec:authorize access="isAuthenticated()"><td><a href="<c:url value='/user/edit/${user.id}' />">Edit</a>
							/ <a href="<c:url value='/user/remove/${user.id}' />">Delete</a></td></sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tableUser').DataTable();
		});
	</script>
</body>
</html>
