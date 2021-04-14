<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

       <div class="row">
           <div class="col-sm-4"></div>
           <div class="col-sm-4">
            <h2>BMI Calculater</h2>



            <form method="post" action="${pageContext.request.contextPath}/fc/bmiresult">
                <div class="form-group">
                   <label for="height">height in cm</label>
                   <input id="height" name="height" type="text" class="form-control"/>
                </div>
                <div class="form-group">
                   <label for="weight">weight in kg</label>
                   <input id="weight" name="weight" type="text" class="form-control"/><br/>
                </div>
                <input type="radio" id="male" name="gender" value="male">
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="female">
                <label for="female">Female</label><br>



                <label for="sport">Your favorite sports:</label>
                <select name="sport" id="sport">
                    <option value="1">jogging</option>
                    <option value="2">football</option>
                    <option value="3">handball</option>
                    <option value="4">yoga</option>
                </select><br/>

                <input type="checkbox" id="hobby1" name="hobby" value="1">
                <label for="hobby1"> I eat healthy food</label><br>
                <input type="checkbox" id="hobby2" name="hobby" value="2">
                <label for="hobby2"> I have a summer house</label><br>
                <input type="checkbox" id="hobby3" name="hobby" value="3">
                <label for="hobby3"> I have a pet</label><br><br>


                <c:if test="${requestScope.error!=null}">
                    <p style="color:orangered">
                        ${requestScope.error}

                    </p>

                </c:if>

                <button type="submit" class="btn btn-primary">Calculate BMI</button>

            </form>


           </div>
           <div class="col-sm-4"></div>
       </div>

        <div>



            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>