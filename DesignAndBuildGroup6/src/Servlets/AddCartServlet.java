package Servlets;

import bean.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer productID=Integer.valueOf(request.getParameter("productID"));
        Float price=Float.parseFloat(request.getParameter("price"));
        String currentClient=(String)request.getSession().getAttribute("CurrentUserName");
        System.out.println(productID);
        Cart cart = SQLs.sqlSelect.getInstance(Cart.class, "select * from cart where clientID=? and productID=?", currentClient, productID);
        System.out.println(cart);
        if(cart==null)
        {
            SQLs.sqlUpdate.universalUpdate("INSERT INTO cart VALUES (?,?,?,?); ",currentClient,productID,1,price);
        }
        else
        {
            Integer number = cart.getNumber();
            SQLs.sqlUpdate.universalUpdate("update cart set number =? where clientID=? and productID=?; ", number+1,currentClient, productID);
        }
        response.sendRedirect("homePage.jsp");
    }
}
