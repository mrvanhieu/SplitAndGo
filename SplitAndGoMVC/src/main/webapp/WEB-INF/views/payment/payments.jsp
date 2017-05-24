<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>trips</title>

<link href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="../webjars/jquery-ui/1.12.1/jquery-ui.min.css" rel="stylesheet" />

</head>
<body>
	<jsp:include page="../header.jsp" />

	<div class="container" style="width=70%">
	<div class="row">
		<div class="form-group">
			<div class="col-sm-2" style="padding-left:0px">
				<select class="form-control" id="selectTripId">
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
		  	<div class="panel-heading"><spring:message code="payment.header" /></div>
			<div  id="paymentsDetail" class="container">
				
			</div>
		</div>
	</div>
	</div>
	
	<div id="paymentDialog"></div>
	
	<div id="confirmDeletePaymentDialog" style="hidden">
		<spring:message code="payment.modal.confirmdelete.content" />
		<input type="hidden" id="paymentId">
	</div>
	
	<script src="../webjars/jquery/3.1.1/jquery.min.js"></script>
	<script src="../webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="../webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
	
	<script>
		$(document).ready(function() {
			$(function() {
				$("#confirmDeletePaymentDialog").dialog({
					title : "<spring:message code='payment.modal.confirmdelete.title' />",
					autoOpen : false,
					height : "auto",
					width : "auto",
					modal: true,
			     	buttons: {
			        	Yes: function() {
			        		$(this).dialog("close");
			        		$.ajax({
			    				type : 'GET',
			    				url : "<spring:url value='/payments/delete/'/>" + $("#paymentId").val(),
			    				success : function(data) {
			    					loadPayments();
			    				},
			    				error : function(e) {
			    					alert(e.responseJSON["message"]);
			    				}
			    			});
				        },
				        Cancel: function() {
				        	$(this).dialog("close");
				        }
			      }
				});
				
				$('#selectTripId').change(function() {
					var selectedTripId = $('#selectTripId option:selected').val();
					//var selectedEntryValue = $('#entryId option:selected').val();
					if (selectedTripId == 0) {
						return;
					}
					loadPayments();
				});
				
				$("#paymentDialog").dialog({
					title: "<spring:message code='payment.dialog.title' />",
					autoOpen: false,
					height: "auto",
					width: "600px",
					open: function (event, ui) {
					    $('#paymentDialog').css('overflow', 'hidden');
					  }
				});
			});
		});
	

		var loadPayments = function() {
			var selectedTripId = $('#selectTripId option:selected').val();
			$.ajax({
				type : 'GET',
				url : "<spring:url value='/payments/paymentsDetail/'/>" + selectedTripId,
				success : function(data) {
					$('#paymentsDetail').html(data);
				},
				error : function(e) {
					alert(e.responseJSON["message"]);
				}
			});
		}
		
		var deletePayment = function(id) {
			$("#paymentId").val(id);
			$("#confirmDeletePaymentDialog").dialog("open");
		}
		
		var showPaymentDialog = function(action, id) {
			var ajaxUrl = "<spring:url value='/payments/add' />";
			if (action == 'edit') {
				ajaxUrl = "<spring:url value='/payments/edit/' />" + id; 
			}
			$.ajax({
				type : "GET",
				url : ajaxUrl,
				success : function(data) {
					var paymentDialog = $("#paymentDialog");
					paymentDialog.html(data);
					paymentDialog.dialog("open");
				},

				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
		
		var editPayment = function(id) {
			showPaymentDialog("edit", id);
		}
		
	</script>
	
</body>
</html>
