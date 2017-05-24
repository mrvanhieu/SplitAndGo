<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<link href="webjars/jquery-ui/1.12.1/jquery-ui.min.css" rel="stylesheet" />

<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>

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
					<!-- <li class="dropdown"><a href="<spring:url value="/trips" />" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><spring:message code="menu.trip" /> <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><spring:message code="menu.trip.members" /></a></li>
							<li><a href="#"><spring:message code="menu.trip.fund" /></a></li>
						</ul> --></li>
					<li><a href="<spring:url value="/trips" />"><spring:message
								code="menu.trip" /></a></li>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="<spring:url value="/members" />"><spring:message
								code="menu.membermanagement" /></a></li>
					</security:authorize>
					<li><a href="<spring:url value="/payments/trips" />"><spring:message
								code="menu.payment" /></a></li>

					<li><a href="<spring:url value="/paymentReports" />"><spring:message
							code="menu.reports" /></a></li>
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

<div id="notificationDialog">

</div>

<script>
$(document).ready(function() {
	$(function() {
		$("#notificationDialog").dialog({
			title : '<spring:message code="notification.message" />',
			autoOpen : false,
			height : "auto",
			width : "auto",
			modal: true,
			buttons: {
				Ok: function() {
					$(this).dialog("close");
				}
		  	}
		});
	})
});
setInterval(getNotification, 5000);
function getNotification(){
			$.ajax({
				type : 'GET',
				url : "<spring:url value='/notifications'/>",
				success : function(data) {
					//$('#paymentsDetail').html(data);
					if(data != ""){
						//alert (data);
						$("#notificationDialog").html(data);
						$("#notificationDialog").dialog("open");
					}
				},
				error : function(e) {
					//alert(e.responseJSON["message"]);
					alert("error");
				}
			});
}


</script>