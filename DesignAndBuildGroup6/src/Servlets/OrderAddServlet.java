package Servlets;

import bean.Cart;
import bean.Order;
import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderAddServlet")
public class OrderAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<Cart> cart= (List<Cart>)request.getSession().getAttribute("cart");
        String userid=(String)request.getSession().getAttribute("CurrentUserName");
        System.out.println(userid);
        List<Order> orders= SQLs.sqlSelect.getInstances(Order.class,"select * from orderlist");
        System.out.println(orders);
        SQLs.sqlUpdate.universalUpdate("INSERT INTO orderlist VALUES (?,?); ", orders.size() + 1, userid);
        Integer i=0;
        String productname;
        for(i=0;i<cart.size();i++) {
            productname=SQLs.sqlSelect.getInstance(Product.class,"select * from product where productID=?",cart.get(i).getProductID()).getProductName();
            System.out.println(productname);
            SQLs.sqlUpdate.universalUpdate("INSERT INTO orderitem  VALUES (?,?,?,?,?); ", orders.size() + 1, cart.get(i).getProductID(),cart.get(i).getNumber(),cart.get(i).getPrice(),productname);
        }
        SQLs.sqlUpdate.universalUpdate("delete from cart;");

        request.getRequestDispatcher("/homePage.jsp").forward(request, response);

    }
}
