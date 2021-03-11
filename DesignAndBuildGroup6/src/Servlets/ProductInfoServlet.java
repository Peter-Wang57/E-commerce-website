package Servlets;

import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> Products= SQLs.sqlSelect.getInstances(Product.class,"select * from product");
        System.out.println(Products);
        request.getSession().setAttribute("Products",Products);
        request.getRequestDispatcher("/homePage.jsp").forward(request, response);
    }
}
