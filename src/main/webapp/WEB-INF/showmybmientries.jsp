<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         List of BMI Entries
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        Here you can find all your BMI in history.
        <table class="table">
            <thead><th>ID</th><th>BMI</th><th>height</th><th>weight</th><th>gender</th></thead>
            <c:forEach var="bmiEntry" items="${requestScope.bmiEntryList}">
                <tr>
                    <td>${bmiEntry.id}</td>
                    <td>${bmiEntry.bmi}</td>
                    <td>${bmiEntry.height}</td>
                    <td>${bmiEntry.weight}</td>
                    <td>${bmiEntry.gender}</td>
                </tr>

            </c:forEach>


        </table>

    </jsp:body>
</t:genericpage>
