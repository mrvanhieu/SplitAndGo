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

	<div class="container">
		<div class="row">
			<a href="<spring:url value='/payments/addMember/'/>" class="btn btn-default btn-sm">
				<span class="glyphicon glyphicon-plus-sign"></span>
				<spring:message code="member.button.addmember" />
			</a>
		</div>
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
			</tbody>
		</table>
	</div>

	<div id="confirmDeleteMemberDialog">
		<spring:message code="member.modal.confirmdelete.content" />
		<input type="hidden" id="memberId">
	</div>

	<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
	
	<script>
		$(document).ready(function() {
			$(function() {
				$("#confirmDeleteMemberDialog").dialog({
					title : "<spring:message code='member.modal.confirmdelete.title' />",
					autoOpen : false,
					height : "auto",
					width : "auto",
					modal: true,
			     	buttons: {
			        	Yes: function() {
			        		$(this).dialog("close");
			        		window.location.href = "members/deleteMember/" + $("#memberId").val();
				        },
				        Cancel: function() {
				        	$(this).dialog("close");
				        }
			      }
				});
			});
		});
		
		var deleteMember = function(id) {
			$("#memberId").val(id);
			$("#confirmDeleteMemberDialog").dialog("open");
		}
	</script>
	
</body>
</html>
