<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/payments/add" var="addUrl" />
<form:form id="addPaymentForm" method="POST" action="${addUrl}" modelAttribute="newPayment"
	class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-sm-4" for="description"><spring:message
				code="payment.description" /></label>
		<div class="col-sm-6">
			<form:textarea path="description" class="form-control" rows="6"/>
			<form:errors path="description" cssClass="text-danger" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="date"><spring:message
				code="payment.date" /></label>
		<div class="col-sm-6">
			<form:input type="date" path="date" class="form-control" />
			<form:errors path="date" cssClass="text-danger" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="amount"><spring:message
				code="payment.amount" /></label>
		<div class="col-sm-6">
			<form:input path="amount" class="form-control" />
			<form:errors path="amount" cssClass="text-danger" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-6">
			<form:hidden path="tripId" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<div class="control-label col-sm-4"></div>
		<div class="col-sm-2">
			<input type="submit" value="Add" class="btn btn-info form-control" />
		</div>
	</div>
</form:form>
<div id="invalidPaymentInputDialog">
	<spring:message code="payment.dialog.invalidamount.content" />
</div>

<script>
	$('#addPaymentForm').submit(function(event) {
		event.preventDefault(); // Prevent the form from submitting via the browser
		$('#tripId').val($('#selectTripId option:selected').val());
		var form = $(this);
		
		var desc = $('#description').val();
		if (!desc || (desc.length < 4 && desc.length > 200)) {
			$("#invalidPaymentInputDialog").html("<spring:message code='payment.dialog.invaliddesc.content'/>");
			$("#invalidPaymentInputDialog").dialog("open");
			return;
		}
		var date = $('#date').val();
		if (!date) {
			$("#invalidPaymentInputDialog").html("<spring:message code='payment.dialog.invaliddate.content'/>");
			$("#invalidPaymentInputDialog").dialog("open");
			return;
		}
		var amount = $('#amount').val();
		if (!amount || parseInt(amount) < 0) {
			$("#invalidPaymentInputDialog").html("<spring:message code='payment.dialog.invalidamount.content'/>");
			$("#invalidPaymentInputDialog").dialog("open");
			return;
		}
		
		$.ajax({
			type : form.attr('method'),
			url : form.attr('action'),
			data : form.serialize(),
			success : function(data) {
				$("#paymentDialog").dialog("close");
				loadPayments();
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	});
	
	$("#invalidPaymentInputDialog").dialog({
		title : '<spring:message code="payment.dialog.invalidinput.title" />',
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
</script>