package Servlets;

import bean.Order;
import bean.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid=(String)request.getSession().getAttribute("CurrentUserName");
        List<Order> orders= SQLs.sqlSelect.getInstances(Order.class,"select * from orderlist where clientID=?",userid);
        List<List<OrderItem>> orderitems = new ArrayList<List<OrderItem>>();


        Integer i=0;
        for(i=0;i<orders.size();i++)
        {
            List<OrderItem> oneorder =SQLs.sqlSelect.getInstances(OrderItem.class,"select * from orderitem where orderID=?",orders.get(i).getOrderID());

            orderitems.add(oneorder);
        }
        request.getSession().setAttribute("order",orderitems);
        request.getRequestDispatcher("/order.jsp").forward(request, response);
    }
}
