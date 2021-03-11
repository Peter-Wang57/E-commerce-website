package Servlets;

import bean.Cart;
import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentUserId=(String)request.getSession().getAttribute("CurrentUserName");
        List<Cart> CartItems= SQLs.sqlSelect.getInstances(Cart.class,"select * from cart where clientID=?",currentUserId);
        request.getSession().setAttribute("cart",CartItems);
        float total=0;
        Integer j=0;
        for(j=0;j<CartItems.size();j++){

//            total+=SQLs.sqlSelect.getInstance(Product.class,"select * from product where productID=?",CartItems.get(j).getProductID()).getPrice()*CartItems.get(j).getNumber();
            total+=CartItems.get(j).getPrice()*CartItems.get(j).getNumber();


        }
        request.getSession().setAttribute("total",total);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
}
