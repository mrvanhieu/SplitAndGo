<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><c:if test="${notificationResults != null}">
	<c:forEach items="${notificationResults}" var="notification" varStatus="loop">
		${notification.description}<br>
	</c:forEach>
</c:if>