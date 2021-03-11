package Servlets;

import bean.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientID=request.getParameter("ClientID");
        String clientPassword=request.getParameter("ClientPassword");

        Client ClientInfo= SQLs.sqlSelect.getInstance(Client.class,"select * from client where clientID=?",clientID);
        if(ClientInfo!=null&&ClientInfo.getPassword().equals(clientPassword))
        {
            request.getSession().setAttribute("CurrentUserName",ClientInfo.getClientID());
            request.setAttribute("IfSucessLogin","true");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("IfSucessLogin","false");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        System.out.println(clientID);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
