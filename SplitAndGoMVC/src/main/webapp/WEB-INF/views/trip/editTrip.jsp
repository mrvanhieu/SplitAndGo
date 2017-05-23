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

<link href="../../webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="../../webjars/jquery-ui/1.12.1/jquery-ui.min.css" rel="stylesheet" />

</head>
<body>
	<jsp:include page="../header.jsp" />

	<div class="container" style="width: 50%">
		<spring:url value="/trips/editTrip/" var="editUrl" />
		<form:form id="editTripForm" method="POST" action="${editUrl}" modelAttribute="trip"
			class="form-horizontal">
			<div class="form-group">
				<form:hidden path="id" class="form-control" />
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="name"><spring:message
						code="trip.name" /></label>
				<div class="col-sm-6">
					<form:input path="name" class="form-control" />
					<form:errors path="name" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="description"><spring:message
						code="trip.description" /></label>
				<div class="col-sm-6">
					<form:textarea path="description" class="form-control" />
					<form:errors path="description" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="startDate"><spring:message
						code="trip.startdate" /></label>
				<div class="col-sm-6">
					<form:input type="date" path="startDate" class="form-control" />
					<form:errors path="startDate" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="endDate"><spring:message
						code="trip.enddate" /></label>
				<div class="col-sm-6">
					<form:input type="date" path="endDate" class="form-control" />
					<form:errors path="endDate" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="duration"><spring:message
						code="trip.duration" /></label>
				<div class="col-sm-6">
					<form:input path="duration" class="form-control" />
					<form:errors path="duration" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="members"><spring:message
						code="trip.members" /></label>
				<div class="col-sm-6">
					<form:select path="members" class="form-control" multiple="true">
						<form:option value="0">
							<spring:message code="trip.select" />
						</form:option>
						<c:forEach items="${members}" var="member">
							<c:forEach items="${trip.members}" var="tripMember">
								<c:if test="${tripMember.id == member.id}">
									<c:set var="selected" value="true"></c:set>
								</c:if>
							</c:forEach>
							<c:if test="${selected eq 'true'}">
								<form:option value="${member.id}" selected="selected">
									${member.firstName}&nbsp${member.lastName}
								</form:option>							
							</c:if>
							<c:if test="${selected ne 'true'}">
								<form:option value="${member.id}">
									${member.firstName}&nbsp${member.lastName}
								</form:option>		
							</c:if>
							<c:set var="selected" value="false"></c:set>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="fund.totalAmount"><spring:message
						code="trip.fund.totalamount" /></label>
				<div class="col-sm-6">
					<form:input path="fund.totalAmount" class="form-control" />
					<form:errors path="fund.totalAmount" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<div class="control-label col-sm-4"></div>
				<div class="col-sm-2">
					<input type="submit" value="Save" class="btn btn-info form-control" />
				</div>
			</div>

		</form:form>
	</div>
	
	<script src="../../webjars/jquery/3.1.1/jquery.min.js"></script>
	<script src="../../webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="../../webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
		});
	</script>
</body>
</html>