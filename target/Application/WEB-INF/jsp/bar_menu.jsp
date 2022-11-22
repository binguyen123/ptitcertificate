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
			<li><a href="/Application">Home</a></li>

			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="admin">Dashboard</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Create New Account<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="signupAdmin">Create New Adminitrator</a></li>
						<li class="divider"></li>
						<li><a href="signupUser">Create New User</a></li>
					</ul></li>
				<li><a href="certificate">Certificate</a></li>
				<li><a href="certificate">Course</a></li>
				<li><a href="editProfile">Information</a>
			</sec:authorize>

			<sec:authorize access="hasRole('ROLE_USER')">
				<li><a href="user">Student</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">StudyInfo<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="course">Course</a></li>
						<li class="divider"></li>
						<li><a href="certificate">Certificate</a></li>
						<li><a href="section">Section</a></li>
					</ul></li>
				<li><a href="editProfile">Information</a>
				</li>
			</sec:authorize>
		</ul>

		<ul class="nav navbar-nav navbar-right">

			<c:if test="${!loginstatus}">
				<li><a href="login">Log In</a></li>
			</c:if>

			<c:if test="${loginstatus}">
				<li><a href="${pageContext.request.contextPath}/">Hi, <sec:authentication
							property="principal.username" />
				</a></li>
				<li><a href="logout">Log Out</a></li>
			</c:if>
		</ul>
	</div>
</div>