<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Members</title>

<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="webjars/jquery-ui/1.12.1/jquery-ui.min.css" rel="stylesheet" />

</head>
<body>
	<jsp:include page="../header.jsp" />

	<div class="container" style="width=70%">
		<div class="row">
			<div class="form-group">
				<div class="col-sm-2" style="padding-left:0px">
					<select class="form-control" id="tripId">
						<option value="0"><spring:message code="payment.select" /></option>
						<c:forEach items="${trips}" var="trip">
							<option value="${trip.id}">${trip.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<br/>
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading"><spring:message code="report.header" /></div>
				<div  id="paymentReportsDetail" class="container">

				</div>
			</div>
		</div>
	</div>
<%--
	<div class="container">

		<br />
		<table class="table table-hover">
			<thead>
				<tr>
					<th></th>
					<th><spring:message code="payment.date" /></th>
					<th><spring:message code="payment.date" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${paymentReports}" var="report" varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>${report}</td>
						<td></td>
						<td><a name="View Report"
							href="<spring:url value='/members/editMember/${member.id}'/>"><span
								class="glyphicon glyphicon-pencil"></span> </a></td>
					</tr>
				</c:forEach>
				<tr>
					<td><a name="View Sample Report"
						   href="<spring:url value='/paymentReports/1/2017-05-23'/>">View Sample Report </a></td>
				</tr>
			</tbody>
		</table>
	</div>--%>

	<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>

	<script>
		$(document).ready(function() {
			$(function() {
				$('#tripId').change(function() {
					var selectedTripId = $('#tripId option:selected').val();
					if (selectedTripId == 0) {
						return;
					}
					loadPayments();
				});
			});
		});

		var loadPayments = function() {
			var selectedTripId = $('#tripId option:selected').val();
			$.ajax({
				type : 'GET',
				url : "<spring:url value='/paymentReports/'/>" + selectedTripId,
				success : function(data) {
					$('#paymentReportsDetail').html(data);
				},
				error : function(e) {
					alert(e.responseJSON["message"]);
				}
			});
		}

	</script>
</body>
</html>
