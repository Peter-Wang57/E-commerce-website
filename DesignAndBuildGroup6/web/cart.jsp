<%@ page import="bean.Cart" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/23
  Time: 7:22
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

    <% List<Cart> CartItems= (List<Cart>) session.getAttribute("cart"); %>

</head>
<body>
<div csslass="container">
    <div class="shadow-sm p-3 mb-5 bg-white rounded">
        <div class="row" >
            <div class="col-md-4 ">
                <a class="btn btn-primary" href="homePage.jsp" role="button">Home Page</a>
            </div>
        </div>
    </div>
    <% Integer i=0;
      for(i=0;i<CartItems.size();i++)
      {%>
        <div class="row" >
            <div class="col-md-1 offset-md-2" style="background-color: rgba(0,0,0,0.02)">
                <img class="book_img rounded" src="static/img/<%=i+1%>.jpg" width="100" height="100"/>
            </div>
            <div class="col-md-1 "style="background-color: rgba(0,0,0,0.02)">
                item
                <%= CartItems.get(i).getProductID()%>
            </div>

            <div class="col-md-1 "style="background-color: rgba(0,0,0,0.02)">
                price:
                <%= CartItems.get(i).getPrice() %>
            </div>
            <div class="col-md-1"style="background-color: rgba(0,0,0,0.02)">
            <a class="btn btn-primary" style="float: right" href="URLOfChangeCartServlet?method=min&productID=<%=CartItems.get(i).getProductID()%>&number=<%=CartItems.get(i).getNumber()%> ">
                -
            </a>
            </div>
            <div class="col-md-1 "style="background-color: rgba(0,0,0,0.02)">
                number:
                <%= CartItems.get(i).getNumber() %>
            </div>
            <div class="col-md-1 "style="background-color: rgba(0,0,0,0.02)">
            <a class="btn btn-primary" style="float: left" href="URLOfChangeCartServlet?method=plu&productID=<%=CartItems.get(i).getProductID()%>&number=<%=CartItems.get(i).getNumber()%> ">
                +
            </a>
            </div>
            <br>
        </div>
    <% }%>
    <div class="row" >
        <div class="col-md-4 offset-md-4">
        total:<%= request.getSession().getAttribute("total")%>
        </div>
    </div>

<br>
    <div class="row" >
        <div class="col-md-4 offset-md-4">
    <a class="btn btn-primary" href="URLOfOrderAddServlet" role="button">submit</a>
        </div>
    </div>
</div>


</body>
</html>
