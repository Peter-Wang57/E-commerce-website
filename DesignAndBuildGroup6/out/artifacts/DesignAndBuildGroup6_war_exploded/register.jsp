<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/23
  Time: 3:51
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

    <%if(request.getAttribute("IfSuccessRegister")!=null)
    {%>
    <%if(request.getAttribute("IfSuccessRegister").equals((Object)"true"))
    {%>
    <script language="javascript" type="text/javascript">
        $(function () {
            $("#successalert").fadeIn();
            setTimeout("location.href='http://localhost:8080/DesignAndBuildGroup6_war_exploded/homePage.jsp'", 3000);
        });
    </script>
    <%}
    else if(request.getAttribute("IfSuccessRegister").equals((Object)"false"))
    {%>
    <script language="javascript" type="text/javascript">
        $(function () {
            $("#failurealert").text("userID exists");
            $("#failurealert").fadeIn();

        });
    </script>
    <%}%>
    <%}%>

    <script language="javascript" type="text/javascript">
        var Patt1 = /^\w{5,12}$/;
        var Patt2 = /^[0-9]{5,12}$/;
        $(function () {

            var $button=$("#RegisterSubmit");
            $button.click(function () {

                // alert($("#InputID")[0].value);
                // alert($("#InputID").val());
                if(!Patt1.test($("#InputID").val())) {
                    $("#failurealert").text("illegali username!!");
                    $("#failurealert").fadeIn();
                    return false;
                }else
                if(!Patt1.test($("#InputPassword1").val())) {
                    $("#failurealert").text("illegali password!!");
                    $("#failurealert").fadeIn();
                    return false;
                }else
                if($("#InputPassword1").val()!=$("#ConfirmPassword1").val()) {
                    $("#failurealert").text("password and confirm password not same!!");
                    $("#failurealert").fadeIn();
                    return false;
                }
                else
                if(!Patt2.test($("#InputPhoneNumber").val())) {
                    $("#failurealert").text("illegali phone number!!");
                    $("#failurealert").fadeIn();
                    return false;
                }else
                if(!Patt1.test($("#InputName").val())) {
                    $("#failurealert").text("illegali name!!");
                    $("#failurealert").fadeIn();
                    return false;
                }else
                {
                    $("#failurealert").fadeOut();
                }



            });
            // $("#successalert").fadeIn();
            // setTimeout("location.href='http://localhost:8080/DesignAndBuildGroup6_war_exploded/URLOfRegisterServlet'", 3000);
        });
    </script>

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

    <div class="row" >
        <div class="col-md-12 ">
            <div class="alert alert-danger" role="alert" style="display:none" id="failurealert">

            </div>
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12 ">
            <div class="alert alert-success" role="alert" style="display:none" id="successalert">
                You have successfully registered! This page will jump 3 seconds later.
            </div>
        </div>
    </div>

    <div class="row" >
        <div class="col-md-4 offset-md-4">
            <div class="shadow-sm p-3 mb-5 bg-white rounded">
                <form action="http://localhost:8080/DesignAndBuildGroup6_war_exploded/URLOfRegisterServlet" method="post">


                    <div class="form-group">
                        <label for="InputID">ID</label>
                        <input type="text" class="form-control" name="ClientID" id="InputID" aria-describedby="emailHelp" placeholder="please enter your id">
                                        <small class="form-text text-muted">5-20 Letters or numbers or "_"</small>
                    </div>
                    <div class="form-group">
                        <label for="InputPassword1">Password</label>
                        <input type="password" class="form-control" name="ClientPassword" id="InputPassword1" placeholder="please enter your password">
                        <small class="form-text text-muted">5-20 Letters or numbers or "_"</small>
                    </div>
                    <div class="form-group">
                        <label for="ConfirmPassword1">Confirm Password</label>
                        <input type="password" class="form-control" name="ConfirmPassword" id="ConfirmPassword1" placeholder="please re-enter your password">
                        <small class="form-text text-muted">5-20 Letters or numbers or "_"</small>
                    </div>
                    <div class="form-group">
                        <label for="InputPhoneNumber">Phone Number</label>
                        <input type="password" class="form-control" name="InputPhoneNumber" id="InputPhoneNumber" placeholder="please re-enter your phone number">
                        <small class="form-text text-muted">5-20 numbers</small>
                    </div>
                    <div class="form-group">
                        <label for="InputPhoneNumber">Name</label>
                        <input type="password" class="form-control" name="InputName" id="InputName" placeholder="please re-enter your name">
                        <small class="form-text text-muted">5-20 Letters or numbers or "_"</small>
                    </div>
                    <button type="submit" class="btn btn-primary" id="RegisterSubmit">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>




</body>
</html>
