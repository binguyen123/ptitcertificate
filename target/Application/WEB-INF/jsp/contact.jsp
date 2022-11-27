<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Contact Us</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/assets/css/bootstrap-united.css" rel="stylesheet" />
<link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<script src="resources/jquery-1.8.3.js"></script>
<script src="resources/bootstrap/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="_barmenu.jsp" />
			<h1 class="col-md-6 col-md-offset-2">Contact to support</h1>
			<p  class="col-md-6 col-md-offset-2">Send your comments through this form and we will get back to
				you.</p>
				<form id="frmContact" name="frmContact" action="contact" method="POST" class="col-md-6 col-md-offset-2">
					<div class="form-group row">
						<label for="name" class="col-sm-2 col-form-label">Your full Name:</label>
						<div class="col-sm-10">
						<input type="text" id="pp-name" name="name"
							placeholder="enter your name here" title="Please enter your name"
							class="form-control required" aria-required="true" required>
						</div>
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-2 col-form-label">Email:</label>
						<div class="col-sm-10">
							<input type="text" id="pp-email" name="email"
								placeholder="enter your email address here"
								title="Please enter your email address" class="form-control required email"
								aria-required="true" required>
							<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
						</div>
					</div>
					<div class="form-group row">
						<label for="phone" class="col-sm-2 col-form-label">Phone Number:</label>
						<div class="col-sm-10">
							<input type="text" id="pp-phone" name="phone"
								placeholder="enter your phone number here"
								title="Please enter your phone number" class="form-control required phone"
								aria-required="true" required>
							<small id="emailHelp" class="form-text text-muted">We'll never share your phone number with anyone else.</small>
						</div>
					</div>
					<div class="form-group row">
						<label for="phone" class="col-sm-2 col-form-label">Message:</label>
						<div class="col-sm-10">
							<textarea id="about-project" name="message" class="form-control"
								placeholder="enter your message here" rows="5" required></textarea>
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