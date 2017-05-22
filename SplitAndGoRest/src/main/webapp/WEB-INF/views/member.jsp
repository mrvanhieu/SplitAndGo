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
        <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
            <div class="thumbnail">
                <div class="caption">
                    <h3><spring:message code="member.firstName"/> - ${member.firstName}</h3>
                    <h3><spring:message code="member.lastName"/> -  ${member.lastName}</h3>
                    <p><spring:message code="member.phone"/> -       ${member.phone} </p>
                    <p><spring:message code="member.email"/> -       ${member.email} </p>

                </div>
            </div>
        </div>

    </div>
</section>

<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
</body>
</html>
