<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<c:set var="ctxRoot" value="${pageContext.request.contextPath}" />
<title>Upload Content Frame Love</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${ctxRoot}/resources/DataTables/datatables.min.css" />

<link href="resources/assets/css/bootstrap-united.css" rel="stylesheet" />
<link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<script src="resources/jquery-1.8.3.js"></script>
<script src="resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${ctxRoot}/resources/DataTables/datatables.min.js" charset="UTF-8"></script>
<script type="text/javascript">
$(document).ready(function() {
	var ajaxUrl = "${ctxRoot}/ajax/frameLoveInfo";
	var domString = '<"table-header clearfix"<"table-caption"><"DT-lf-right"<"DT-per-page"l>>r>t';		// header and table body
	domString = domString + '<"table-footer clearfix"<"DT-label"i><"DT-pagination"p>>';	// footer
    $('#frameLoveInfo').DataTable({
    	searching: true, 
        responsive: true,
        "processing": true,
        "serverSide": true,
        "ajax":{
        	"url": ajaxUrl
        },
        "columns": [
            { "data": "id" },
            { "data": "package_id" },
            { "data": "package_path" },
            { "data": "package_type" },
            { "data": "purchase_count" }
        ],
        "select":true ,
		"order": [[ 0, "desc" ]],	                
    	"dom": domString
    	,
    	"createdRow": function ( row, data, index ) 
    	{
    		$(row).attr('title', data.resultMessage);
        }
    });
});
</script>
</head>
<body>
	<jsp:include page="bar_menu.jsp" />
			<h1 class="col-md-6 col-md-offset-2">Select content to upload</h1>
			<p  class="col-md-6 col-md-offset-2">Upload your content</p>
				<form id="frmUpload" name="frmUpload" action="uploadContentFrameLove" method="POST" class="col-md-6 col-md-offset-2" enctype="multipart/form-data">
					<div class="form-group row">
						<label for="file_content" class="col-sm-2 col-form-label">Content File:</label>
						<div class="col-sm-8">
							<input type="File" id="file_content" name="file_content" class="form-control required" aria-required="true" required>
							<small id="emailHelp" class="form-text text-muted">select file to update content for frame love</small>
						</div>
						<div class="col-sm-2">		
							<input type="submit" name="submit" value="Upload File" id="send-message" class="btn btn-primary pull-right">
						</div>
					</div>
					<table id="frameLoveInfo" class="display" style="width:100%">
				        <thead>
				            <tr>
				                <th>id</th>
				                <th>Package Id</th>
				                <th>File Name</th>
				                <th>Package Type</th>
				                <th>Purchase Count</th>
				            </tr>
				        </thead>
				    </table>
					<c:if test = "${status != null}">
						<c:if test = "${status == 'success'}">
							<div class="alert alert-dismissible alert-success pull-left">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								${message}
							</div>	
						</c:if>
						<c:if test = "${status == 'error'}">
							<div class="alert alert-dismissible alert-danger pull-left">
 									<button type="button" class="close" data-dismiss="alert">&times;</button>
									${message}
							</div>
						</c:if>
					</c:if>
				</form>
</body>
</html>