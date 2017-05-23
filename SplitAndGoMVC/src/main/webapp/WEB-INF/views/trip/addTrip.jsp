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
</head>
<body>
	<jsp:include page="../header.jsp" />

	<div class="container" style="width: 50%">
		<form:form id="addTripForm" method="POST" modelAttribute="trip"
			class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-4" for="firstName"><spring:message
						code="member.firstname" /></label>
				<div class="col-sm-6">
					<form:input path="firstName" class="form-control" />
					<form:errors path="firstName" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="lastName"><spring:message
						code="member.lastname" /></label>
				<div class="col-sm-6">
					<form:input path="lastName" class="form-control" />
					<form:errors path="lastName" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="nickName"><spring:message
						code="member.nickname" /></label>
				<div class="col-sm-6">
					<form:input path="nickName" class="form-control" />
					<form:errors path="nickName" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="gender"><spring:message
						code="member.gender" /></label>
				<div class="col-sm-6">
					<form:select path="gender" class="form-control">
						<form:option value="" selected="true">
							<spring:message code="member.select" />
						</form:option>
						<form:option value="MALE">
							<spring:message code="member.gender.select.male" />
						</form:option>
						<form:option value="FEMALE">
							<spring:message code="member.gender.select.female" />
						</form:option>
					</form:select>
					<form:errors path="gender" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="birthDate"><spring:message
						code="member.birthdate" /></label>
				<div class="col-sm-6">
					<form:input type="date" path="birthDate" class="form-control" />
					<form:errors path="birthDate" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="email"><spring:message
						code="member.email" /></label>
				<div class="col-sm-6">
					<form:input path="email" class="form-control" />
					<form:errors path="email" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="phone"><spring:message
						code="member.phone" /></label>
				<div class="col-sm-6">
					<form:input path="phone" class="form-control" />
					<form:errors path="phone" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="credential.username"><spring:message
						code="member.credential.username" /></label>
				<div class="col-sm-6">
					<form:input path="credential.username" class="form-control" />
					<form:errors path="credential.username" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="credential.password"><spring:message
						code="member.credential.password" /></label>
				<div class="col-sm-6">
					<form:password path="credential.password" class="form-control" />
					<form:errors path="credential.password" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="credential.authorityList"><spring:message
						code="member.authority" /></label>
				<div class="col-sm-6">
					<form:select path="credential.authorityList" class="form-control" multiple="true">
						<form:option value="">
							<spring:message code="member.authority.select" />
						</form:option>
						<form:option value="ROLE_ADMIN">
							<spring:message code="member.authority.select.admin" />
						</form:option>
						<form:option value="ROLE_USER">
							<spring:message code="member.authority.select.user" />
						</form:option>
					</form:select>
					<form:errors path="credential.authorityList" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<div class="control-label col-sm-4"></div>
				<div class="col-sm-2">
					<input type="submit" value="Add" class="btn btn-info form-control" />
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>