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
			<a href="<spring:url value='/members/addMember/'/>" class="btn btn-default btn-sm">
				<span class="glyphicon glyphicon-plus-sign"></span>
				<spring:message code="member.button.addmember" />
			</a>
		</div>
		<br />
		<table class="table table-hover">
			<thead>
				<tr>
					<th></th>
					<th><spring:message code="member.firstname" /></th>
					<th><spring:message code="member.lastname" /></th>
					<th><spring:message code="member.nickname" /></th>
					<th><spring:message code="member.gender" /></th>
					<th><spring:message code="member.birthdate" /></th>
					<th><spring:message code="member.email" /></th>
					<th><spring:message code="member.phone" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members}" var="member" varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>${member.firstName}</td>
						<td>${member.lastName}</td>
						<td>${member.nickName}</td>
						<td>${member.gender}</td>
						<td>${member.birthDate}</td>
						<td>${member.email}</td>
						<td>${member.phone}</td>
						<td><a
							href="<spring:url value='/members/editMember/${member.id}'/>"><span
								class="glyphicon glyphicon-pencil"></span> </a>| <a
							href='javascript:deleteMember(${member.id})'><span
								class="glyphicon glyphicon-trash"></span></a></td>
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
