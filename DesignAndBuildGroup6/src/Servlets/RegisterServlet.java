package Servlets;

import bean.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientID = request.getParameter("ClientID");
        String clientPassword = request.getParameter("ClientPassword");
        String inputPhoneNumber = request.getParameter("InputPhoneNumber");
        String inputName = request.getParameter("InputName");
        Client client= SQLs.sqlSelect.getInstance(Client.class,"select * from client where clientID=?",clientID);
        if(client!=null)
        {
            request.setAttribute("IfSuccessRegister","false");
            System.out.println("false");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        else
        {
            SQLs.sqlUpdate.universalUpdate("INSERT INTO client VALUES (?,?,?,?,?,?); ",clientID,clientPassword,null,inputPhoneNumber,null,inputName);
            System.out.println("true");
            request.setAttribute("IfSuccessRegister","true");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
}
