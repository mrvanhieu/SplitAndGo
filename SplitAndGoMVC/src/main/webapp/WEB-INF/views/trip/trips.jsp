<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>trips</title>

<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="webjars/jquery-ui/1.12.1/jquery-ui.min.css" rel="stylesheet" />

</head>
<body>
	<jsp:include page="../header.jsp" />

	<div class="container">
		<div class="row">
			<security:authorize access="hasRole('ROLE_ADMIN')">
			<a href="<spring:url value='/trips/addTrip/'/>" class="btn btn-default btn-sm">
				<span class="glyphicon glyphicon-plus-sign"></span>
				<spring:message code="trip.button.addtrip" />
			</a>
			</security:authorize>
		</div>
		<br />
		<table class="table table-hover">
			<thead>
				<tr>
					<th></th>
					<th><spring:message code="trip.name" /></th>
					<th><spring:message code="trip.startdate" /></th>
					<th><spring:message code="trip.enddate" /></th>
					<th><spring:message code="trip.fund.totalamount" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${trips}" var="trip" varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>${trip.name}</td>
						<td>${trip.startDate}</td>
						<td>${trip.endDate}</td>
						<td>${trip.fund.totalAmount}
						<td><security:authorize access="hasRole('ROLE_ADMIN')"><a
							href="<spring:url value='/trips/editTrip/${trip.id}'/>"><span
								class="glyphicon glyphicon-pencil"></span> </a>| <a
							href='javascript:deleteTrip(${trip.id})'><span
								class="glyphicon glyphicon-trash"></span></a></security:authorize></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div id="confirmDeleteTripDialog">
		<spring:message code="trip.modal.confirmdelete.content" />
		<input type="hidden" id="tripId">
	</div>

	<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
	
	<script>
		$(document).ready(function() {
			$(function() {
				$("#confirmDeleteTripDialog").dialog({
					title : "<spring:message code='trip.modal.confirmdelete.title' />",
					autoOpen : false,
					height : "auto",
					width : "auto",
					modal: true,
			     	buttons: {
			        	Yes: function() {
			        		$(this).dialog("close");
			        		window.location.href = "trips/deleteTrip/" + $("#tripId").val();
				        },
				        Cancel: function() {
				        	$(this).dialog("close");
				        }
			      }
				});
			});
		});
		
		var deleteTrip = function(id) {
			$("#tripId").val(id);
			$("#confirmDeleteTripDialog").dialog("open");
		}
	</script>
	
</body>
</html>
