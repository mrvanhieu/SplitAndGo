<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table class="table table-hover">
	<thead>
		<tr>
			<th></th>
			<th><spring:message code="report.header" /></th>
			<th><spring:message code="report.download" /></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${paymentReports}" var="paymentReport" varStatus="loop">
			<tr>
				<td>${loop.index + 1}</td>
				<td>${paymentReport.date}</td>
				<td><a name="View Sample Report"
					   href="<spring:url value='/paymentReports/${paymentReport.id}/${paymentReport.date}'/>">Download</a></td>
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