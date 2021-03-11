package Servlets;

import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Product ShowProduct= SQLs.sqlSelect.getInstance(Product.class,"select * from product where productID=?",request.getParameter("productID"));
        request.setAttribute("ShowProduct",ShowProduct);
            request.getRequestDispatcher("/detailPage.jsp").forward(request, response);
    }
}
