<%@ page import="bean.OrderItem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/23
  Time: 13:27
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

    <% List<List<OrderItem>> orderitems= (List<List<OrderItem>>) session.getAttribute("order"); %>
</head>
<body>
<%--<%=session.getAttribute("order")%>--%>
<div csslass="container">
    <div class="shadow-sm p-3 mb-5 bg-white rounded">
        <div class="row" >
            <div class="col-md-4 ">
                <a class="btn btn-primary" href="homePage.jsp" role="button">Home Page</a>
            </div>
        </div>
    </div>

    <% Integer i=0;
        Integer j=0;
        float total=0;
        for (i=0;i<orderitems.size();i++)
        {%>
    <HR>
        <div class="row" >
            <div class="col-md-1 offset-md-2" >
                order<%=i%>
            </div>
        </div>
    <br>

        <%for(j=0;j<orderitems.get(i).size();j++)
            {
                total+=orderitems.get(i).get(j).getNumber()*orderitems.get(i).get(j).getPrice();
        %>
            <div class="row" >
                <div class="col-md-2 offset-md-2">
                    <img src="static/img/<%=orderitems.get(i).get(j).getProductID()%>.jpg" width="200" height="200">
                </div>
            <div class="col-md-2" >
                itemname:<%=orderitems.get(i).get(j).getProducname()%>
<br>
                number:
                <%=orderitems.get(i).get(j).getNumber()%>
                <br>
                price:
                <%=orderitems.get(i).get(j).getPrice()%>
            </div>
            </div>
        <%}%>


        <div class="row" >
            <div class="col-md-1 offset-md-2">
                total: <%=total%>
            </div>
        </div>

        <%}%>
</div>
</body>
</html>
