<%@ page import="bean.Product" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/23
  Time: 6:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/js/bootstrap.bundle.min.js"></script>


</head>
<body>
<div csslass="container">
    <div class="shadow-sm p-3 mb-5 bg-white rounded">
        <div class="row" >
            <div class="col-md-1 ">
                <a class="btn btn-primary" href="homePage.jsp" role="button">HomePage</a>
            </div>
        <% if(session.getAttribute("CurrentUserName")!=null){ %>

            <div class="col-md-4 ">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <%=session.getAttribute("CurrentUserName") %>
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="alert.html">MyPage</a>
                        <a class="dropdown-item" href="http://localhost:8080/DesignAndBuildGroup6_war_exploded/URLOfCartServlet">MyCart</a>
                        <a class="dropdown-item" href="http://localhost:8080/DesignAndBuildGroup6_war_exploded/URLOfLogoutServlet">LogOut</a>

                </div>
            </div>
        </div>

        <%} else {%>

            <div class="col-md-4 ">
                <a class="btn btn-primary" href="login.jsp" role="button">Login</a>
                <a class="btn btn-primary" href="register.jsp" role="button">Register</a>
            </div>

        <%}%>

        </div>
    </div>
    <div class="row" >
        <div class="col-md-4 offset-md-2">
            <% Product product=(Product)request.getAttribute("ShowProduct");%>
            <img src="static/img/<%= product.getProductID()%>.jpg" width="400" height="400">
        </div>

        <div class="col-md-3 ">
<br><br><br>
<h3>
<%=product.getType1()%>
</h3>

<h5>
<%=product.getType2()%>
</h5>

<%=product.getDetails()%>
        </div>

    </div>
    <div class="col-md-4 offset-md-4">
        <% if(session.getAttribute("CurrentUserName")!=null){ %>
        <a href="URLOfAddCartServlet?productID=<%=product.getProductID()%>&price=<%=product.getPrice()%>" class="btn btn-primary">Add To Cart</a>
        <%}%>
    </div>
</div>
</body>
</html>
