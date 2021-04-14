<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        <p>Are you ready to see how fat you are?</p>
        <p>Go to <a href="${pageContext.request.contextPath}">homepage</a>  and start</p>
        <h3>Would you like to see all your BMI calculation?</h3>
        <p><a href="${pageContext.request.contextPath}/fc/mybmientries">Show your BMI history</a></p>

    </jsp:body>

</t:genericpage>

