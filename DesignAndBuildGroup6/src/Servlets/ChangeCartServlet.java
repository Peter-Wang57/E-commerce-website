package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeCartServlet")
public class ChangeCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------");
        String userid = (String) request.getSession().getAttribute("CurrentUserName");
        System.out.println(userid);

        Integer itemname = Integer.valueOf( request.getParameter("productID"));
        System.out.println(itemname);

        Integer number = Integer.valueOf(request.getParameter("number"));
        System.out.println(number);
        if (request.getParameter("method").equals("min")) {
            if (number == 1) {
                SQLs.sqlUpdate.universalUpdate("delete from cart  where clientID=? and productID=?; ", userid, itemname);
                request.getRequestDispatcher("/URLOfCartServlet").forward(request, response);
            } else {
                SQLs.sqlUpdate.universalUpdate("update cart set number=? where clientID=? and productID=?; ", number - 1, userid, itemname);
                request.getRequestDispatcher("/URLOfCartServlet").forward(request, response);
            }

        }
        else
        {
            SQLs.sqlUpdate.universalUpdate("update  cart set number=? where clientID=? and productID=?; ", number + 1, userid, itemname);
            request.getRequestDispatcher("/URLOfCartServlet").forward(request, response);

        }
    }
}
