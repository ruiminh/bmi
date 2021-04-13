<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         resultpage for calculating BMI
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>


        <div>
        <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <h2>BMI result</h2>


            <p>
            Your height is ${requestScope.height} cm<br/>
            Your weight is ${requestScope.weight} kg<br/>
            </p>
            <p>
            Your BMI is ${requestScope.bmi}<br/>
            </p>
            <p>
            Your are ${requestScope.category}
            </p>
        </div>

            <div class="col-sm-4"></div>


        </div>

    </jsp:body>
</t:genericpage>