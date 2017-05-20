<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="container">
	<h1>
		<spring:message code="app.name" />
	</h1>
</div>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<security:authorize access="isAuthenticated()">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><spring:message code="menu.trip" /> <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><spring:message code="menu.trip.members" /></a></li>
							<li><a href="#"><spring:message code="menu.trip.fund" /></a></li>
						</ul></li>
					<li><a href="<spring:url value="/" />"><spring:message
								code="menu.payment" /></a></li>
				</security:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li><a href="<spring:url value='/login' />"><span
							class="glyphicon glyphicon-log-in"></span> <spring:message
								code="login.label" /></a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li><a href="#"><spring:message code="menu.welcome" />&nbsp;
							<security:authentication property="principal.username" /></a></li>
					<li><a href="<spring:url value='/doLogout' />"><span
							class="glyphicon glyphicon-log-out"></span> <spring:message
								code="logout.label" /></a></li>
				</security:authorize>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
