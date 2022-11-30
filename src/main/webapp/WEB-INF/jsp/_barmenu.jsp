<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="navbar navbar-default">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-responsive-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
	</div>

	<div class="navbar-collapse collapse navbar-responsive-collapse">
		<ul class="nav navbar-nav navbar-left">
			<li><a href="${pageContext.request.contextPath}/">Home</a></li>

			<sec:authorize access="isAuthenticated()">
				<li><a href="${pageContext.request.contextPath}/user/list">Users</a></li>
			</sec:authorize>
			
			<li><a href="${pageContext.request.contextPath}/person/list">Student</a></li>
			
			<li><a
				href="${pageContext.request.contextPath}/certificate/list">Certificate</a></li>
			<li><a href="${pageContext.request.contextPath}/course/list">Course</a></li>
			<li><a href="${pageContext.request.contextPath}/subject/list">Subject</a></li>
			<li><a href="${pageContext.request.contextPath}/program/list">Program</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">

			<sec:authorize access="not isAuthenticated()">
				<li><a href="${pageContext.request.contextPath}/login">Log
						In</a></li>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<li><a href="${pageContext.request.contextPath}/">Hi, <sec:authentication
							var="principal" property="principal" /> ${principal.username}
				</a></li>
				<li><a href="${pageContext.request.contextPath}/logout">Log
						Out</a></li>
			</sec:authorize>
		</ul>
	</div>
</div>