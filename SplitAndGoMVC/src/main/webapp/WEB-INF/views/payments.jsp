<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Members</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<section class="container">
    <div class="row">
        <c:forEach items="${payments}" var="payment">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h4><spring:message code="payment.amount"/> - ${payment.amount}</h4>
                        <h4><spring:message code="payment.date"/> - ${payment.date}
                            <a href="<spring:url value="/payments/${payment.id}" />" class="btn btn-primary  btn-mini  ">View</a>
                        </h4>
                        <h4><spring:message code="payment.description"/> - ${payment.description}</h4>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
</body>
</html>
