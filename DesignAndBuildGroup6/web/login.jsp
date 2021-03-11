<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/23
  Time: 2:06
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

    <%if(request.getAttribute("IfSucessLogin")!=null)
    {%>
        <%if(request.getAttribute("IfSucessLogin").equals((Object)"true"))
            {%>
                <script language="javascript" type="text/javascript">
                    $(function () {
                        $("#successalert").fadeIn();
                        setTimeout("location.href='http://localhost:8080/DesignAndBuildGroup6_war_exploded/URLOfProductInfoServlet'", 3000);
                    });
                </script>
        <%}
        else if(request.getAttribute("IfSucessLogin").equals((Object)"false"))
        {%>
            <script language="javascript" type="text/javascript">
                $(function () {
                    $("#failurealert").fadeIn();

                });
            </script>
        <%}%>
    <%}%>

</head>
<body>



<%--<%=request.getAttribute("IfSucessLogin")%>--%>


<div csslass="container">

    <div class="shadow-sm p-3 mb-5 bg-white rounded">
        <div class="row" >
            <div class="col-md-4 ">
                <a class="btn btn-primary" href="homePage.jsp" role="button">Home Page</a>
            </div>
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12 ">
            <div class="alert alert-danger" role="alert" style="display:none" id="failurealert">
                Wrong userid or password!!!
            </div>
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12 ">
            <div class="alert alert-success" role="alert" style="display:none" id="successalert">
                You have successfully login! This page will jump 3 seconds later.
            </div>
        </div>
    </div>


    <div class="row" >
        <div class="col-md-4 offset-md-4">
            <div class="shadow-sm p-3 mb-5 bg-white rounded">
        <form action="http://localhost:8080/DesignAndBuildGroup6_war_exploded/URLOfLoginServlet" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">ID</label>
                <input type="text" class="form-control" name="ClientID" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="please enter your id">
<%--                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" name="ClientPassword" id="exampleInputPassword1" placeholder="please enter your password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        </div>
        </div>
    </div>
</div>

</body>
</html>
