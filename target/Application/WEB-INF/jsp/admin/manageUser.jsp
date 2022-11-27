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
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqwidgets/jqxbuttons.js"></script>

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/scripts/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/jqwidgets/jqxdatatable.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqwidgets/jqxlistbox.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/jqwidgets/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqwidgets/jqxdata.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqwidgets/jqxtooltip.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqwidgets/jqxinput.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqwidgets/demos.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var ordersSource =
                {
                    dataFields: [
                        {name: 'id', type: 'Long'},
                        {name: 'username', type: 'String'},
                        {name: 'password', type: 'String'}
                    ],
                    root: "user",
                    record: "user",
                    dataType: "json",
                    id: 'id',
                    url: "${pageContext.request.contextPath}/getDataForTable",

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
            var dataAdapter = new $.jqx.dataAdapter(ordersSource, {
                loadComplete: function () {
                    // data is loaded.
                }
            });
            $("#table").jqxDataTable(
                {
                    width: getWidth("dataTable"),
                    source: dataAdapter,

                    pageable: true,
                    editable: true,
                    showToolbar: true,
                    altRows: true,
                    ready: function () {
                        // called when the DataTable is loaded.
                    },
                    pagerButtonsCount: 8,
                    toolbarHeight: 35,
                    renderToolbar: function (toolBar) {
                        var toTheme = function (className) {
                            if (theme === "") return className;
                            return className + " " + className + "-" + theme;
                        }
                        // appends buttons to the status bar.
                        var container = $("<div style='overflow: hidden; position: relative; height: 100%; width: 100%;'></div>");
                        var buttonTemplate = "<div style='float: left; padding: 3px; margin: 2px;'><div style='margin: 4px; width: 16px; height: 16px;'></div></div>";
                        var addButton = $(buttonTemplate);
                        var editButton = $(buttonTemplate);
                        var deleteButton = $(buttonTemplate);
                        var cancelButton = $(buttonTemplate);
                        var updateButton = $(buttonTemplate);
                        container.append(addButton);
                        container.append(editButton);
                        container.append(deleteButton);
                        container.append(cancelButton);
                        container.append(updateButton);
                        toolBar.append(container);
                        addButton.jqxButton({cursor: "pointer", enableDefault: false, height: 25, width: 25});
                        addButton.find('div:first').addClass(toTheme('jqx-icon-plus'));
                        addButton.jqxTooltip({position: 'bottom', content: "Add"});
                        editButton.jqxButton({
                            cursor: "pointer",
                            disabled: true,
                            enableDefault: false,
                            height: 25,
                            width: 25
                        });
                        editButton.find('div:first').addClass(toTheme('jqx-icon-edit'));
                        editButton.jqxTooltip({position: 'bottom', content: "Edit"});
                        deleteButton.jqxButton({
                            cursor: "pointer",
                            disabled: true,
                            enableDefault: false,
                            height: 25,
                            width: 25
                        });
                        deleteButton.find('div:first').addClass(toTheme('jqx-icon-delete'));
                        deleteButton.jqxTooltip({position: 'bottom', content: "Delete"});
                        updateButton.jqxButton({
                            cursor: "pointer",
                            disabled: true,
                            enableDefault: false,
                            height: 25,
                            width: 25
                        });
                        updateButton.find('div:first').addClass(toTheme('jqx-icon-save'));
                        updateButton.jqxTooltip({position: 'bottom', content: "Save Changes"});
                        cancelButton.jqxButton({
                            cursor: "pointer",
                            disabled: true,
                            enableDefault: false,
                            height: 25,
                            width: 25
                        });
                        cancelButton.find('div:first').addClass(toTheme('jqx-icon-cancel'));
                        cancelButton.jqxTooltip({position: 'bottom', content: "Cancel"});
                        var updateButtons = function (action) {
                            switch (action) {
                                case "Select":
                                    addButton.jqxButton({disabled: false});
                                    deleteButton.jqxButton({disabled: false});
                                    editButton.jqxButton({disabled: false});
                                    cancelButton.jqxButton({disabled: true});
                                    updateButton.jqxButton({disabled: true});
                                    break;
                                case "Unselect":
                                    addButton.jqxButton({disabled: false});
                                    deleteButton.jqxButton({disabled: true});
                                    editButton.jqxButton({disabled: true});
                                    cancelButton.jqxButton({disabled: true});
                                    updateButton.jqxButton({disabled: true});
                                    break;
                                case "Edit":
                                    addButton.jqxButton({disabled: true});
                                    deleteButton.jqxButton({disabled: true});
                                    editButton.jqxButton({disabled: true});
                                    cancelButton.jqxButton({disabled: false});
                                    updateButton.jqxButton({disabled: false});
                                    break;
                                case "End Edit":
                                    addButton.jqxButton({disabled: false});
                                    deleteButton.jqxButton({disabled: false});
                                    editButton.jqxButton({disabled: false});
                                    cancelButton.jqxButton({disabled: true});
                                    updateButton.jqxButton({disabled: true});
                                    break;
                            }
                        }
                        var rowIndex = null;
                        $("#table").on('rowSelect', function (event) {
                            var args = event.args;
                            rowIndex = args.index;
                            updateButtons('Select');
                        });
                        $("#table").on('rowUnselect', function (event) {
                            updateButtons('Unselect');
                        });
                        $("#table").on('rowEndEdit', function (event) {
                            updateButtons('End Edit');
                        });
                        $("#table").on('rowBeginEdit', function (event) {
                            updateButtons('Edit');
                        });
                        addButton.click(function (event) {
                            if (!addButton.jqxButton('disabled')) {
                                // add new empty row.
                                $("#table").jqxDataTable('addRow', null, {}, 'first');
                                // select the first row and clear the selection.
                                $("#table").jqxDataTable('clearSelection');
                                $("#table").jqxDataTable('selectRow', 0);
                                // edit the new row.
                                $("#table").jqxDataTable('beginRowEdit', 0);
                                updateButtons('add');
                            }
                        });
                        cancelButton.click(function (event) {
                            if (!cancelButton.jqxButton('disabled')) {
                                // cancel changes.
                                $("#table").jqxDataTable('endRowEdit', rowIndex, true);
                            }
                        });
                        updateButton.click(function (event) {
                            if (!updateButton.jqxButton('disabled')) {
                                // save changes.
                                $("#table").jqxDataTable('endRowEdit', rowIndex, false);
                            }
                        });
                        editButton.click(function () {
                            if (!editButton.jqxButton('disabled')) {
                                $("#table").jqxDataTable('beginRowEdit', rowIndex);
                                updateButtons('edit');
                            }
                        });
                        deleteButton.click(function () {
                            if (!deleteButton.jqxButton('disabled')) {
                                $("#table").jqxDataTable('deleteRow', rowIndex);
                                updateButtons('delete');
                            }
                        });
                    },
                    columns: [
                        {
                            text: 'User ID',
                            editable: false,
                            dataField: 'id',
                            width: 200},
                        {
                            text: 'User Name',
                            dataField: 'username',
                            cellsFormat: 'f',
                            cellsAlign: 'right',
                            align: 'right',
                            width: 200
                        },
                        {   text: 'Password ',
                            dataField: 'password',
                            ellsAlign: 'right',
                            align: 'right'}
                    ]
                });
        });
    </script>


    <title>Manage User</title>

</head>
<body>
<jsp:include page="../_barmenu.jsp"/>

<br>
<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">

                    <form:form id="myForm" method="POST"
                               action="${pageContext.request.contextPath}/addUser"
                               class="bs-example form-horizontal" modelAttribute="user">
                        <fieldset>
                            <legend>User</legend>

                            <div class="form-group">
                                <label for="nameInput" class="col-lg-3 control-label">Username:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control"
                                                path="username" name="username" id="nameInput"
                                                placeholder="User Name"/>
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

                                <input class="btn btn-primary" style='margin-top: 20px;' type="submit" value="Confirm"
                                       id='jqxSubmitButton'/>

                                <input class="btn btn-default" style='margin-top: 20px;' type="button" value="cancel"
                                       id='jqxButton'/>

                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="padding: 1%; border: 1px solid black">
    <c:if test="${!empty listUsers}">
        <table class="tg" id="tableUser">
            <thead>
            <tr>
                <th>Id</th>
                <th>UserName</th>
                <th>Password</th>
                <th>Edit/Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listUsers}" var="user">
                <tr id="${user.id}">
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td><a href="<c:url value='/editUser/${user.id}' />">Edit</a> /
                        <a href="<c:url value='/removeUser/${user.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

<div id="table"></div>

</body>
</html>
