<%@ page import="bean.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/22
  Time: 21:43
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


    <% List<Product> Products= (List<Product>) session.getAttribute("Products"); %>
</head>
<body>





<div csslass="container">
    <div class="shadow-sm p-3 mb-5 bg-white rounded">
        <% if(session.getAttribute("CurrentUserName")!=null){ %>
            <div class="row" >
            <div class="col-md-4 ">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Welcome <%=session.getAttribute("CurrentUserName") %>
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="myPage.jsp">MyPage</a>
                        <a class="dropdown-item" href="http://localhost:8080/DesignAndBuildGroup6_war_exploded/URLOfCartServlet">MyCart</a>
                        <a class="dropdown-item" href="http://localhost:8080/DesignAndBuildGroup6_war_exploded/URLOfLogoutServlet">LogOut</a>
                    </div>
                </div>
                </div>
            </div>
        <%} else {%>
        <div class="row" >
            <div class="col-md-4 ">
                <a class="btn btn-primary" href="login.jsp" role="button">Login</a>
                <a class="btn btn-primary" href="register.jsp" role="button">Register</a>
            </div>
        </div>
        <%}%>
    </div>
    <br><br><br>
    <div class="row" >
        <% Integer i=0;
        for (i=0;i<3;i++)
        { %>
        <div class="col-md-4 ">
<%--        <%= Products.get(i)%>--%>

    <div class="card center" style="width: 20rem;margin-left:13%;">
        <img src="static/img/<%=Products.get(i).getProductID()%>.jpg" class="card-img-top" alt="..."  width="200" height="200">
        <div class="card-body">
            <h5 class="card-title"><%=Products.get(i).getType1()%></h5>
            <p class="card-text"><%=Products.get(i).getType2()%></p>
            <% if(session.getAttribute("CurrentUserName")!=null){ %>
            <a href="URLOfAddCartServlet?productID=<%=Products.get(i).getProductID()%>&price=<%=Products.get(i).getPrice()%>" class="btn btn-primary">Add To Cart</a>
            <%}%>
            <a href="URLOfProductDetailServlet?productID=<%=Products.get(i).getProductID()%>" class="btn btn-primary">Learn more</a>
        </div>
    </div>
        </div>
        <% } %>
    </div>
</div>

<br>

</body>
</html>
