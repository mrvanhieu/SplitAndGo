<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="row">
	<a id="createPayment"  href="#" class="btn btn-default btn-sm">
		<span class="glyphicon glyphicon-plus-sign"></span>
		<spring:message code="trip.button.addtrip" />
	</a>
</div>

<table class="table table-hover">
	<thead>
		<tr>
			<th></th>
			<th><spring:message code="payment.description" /></th>
			<th><spring:message code="payment.date" /></th>
			<th><spring:message code="payment.amount" /></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${payments}" var="payment" varStatus="loop">
			<tr>
				<td>${loop.index + 1}</td>
				<td>${payment.description}</td>
				<td>${payment.date}</td>
				<td>${payment.amount}</td>
				<td><a href='javascript:editPayment(${payment.id})'><span
						class="glyphicon glyphicon-pencil"></span> </a>| <a
					href='javascript:deletePayment(${payment.id})'><span
						class="glyphicon glyphicon-trash"></span></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	$(document).ready(function() {
		$(function() {
			$("#createPayment").on("click", function() {
				showPaymentDialog("create");
			});
		});
	});
</script>