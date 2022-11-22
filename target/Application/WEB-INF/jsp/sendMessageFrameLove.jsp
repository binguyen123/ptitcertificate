<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Send Push Notification</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/assets/css/bootstrap-united.css" rel="stylesheet" />
<link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<script src="resources/jquery-1.8.3.js"></script>
<script src="resources/bootstrap/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="bar_menu.jsp" />
			<h1 class="col-md-6 col-md-offset-2">Send Push Notification to mobile</h1>
			<p  class="col-md-6 col-md-offset-2">Send Push notification for mobile in list
				you.</p>
				<form id="frmContact" name="frmContact" action="sendMessageFrameLove" method="POST" class="col-md-6 col-md-offset-2">
					<div class="form-group row">
						<label for="title" class="col-sm-2 col-form-label">Title message:</label>
						<div class="col-sm-10">
							<input type="text" id="pp-phone" name="title"
								placeholder="Please enter your title for message push"
								class="form-control required"
								aria-required="true" required>
						</div>
					</div>
					<div class="form-group row">
						<label for="body" class="col-sm-2 col-form-label">Message:</label>
						<div class="col-sm-10">
							<textarea id="about-project" name="body" class="form-control"
								placeholder="Enter your message here" rows="5" required></textarea>
						</div>
					</div>
					<input type="submit" name="submit" value="Send message" id="send-message" class="btn btn-primary btn-lg pull-right">
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