package com.finance.web;

import com.finance.dao.UserDAO;
import com.finance.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        try{
            User u=new UserDAO().login(req.getParameter("email"),req.getParameter("password"));
            if(u==null){req.setAttribute("error","Invalid email or password.");req.getRequestDispatcher("login.jsp").forward(req,resp);return;}
            req.getSession().setAttribute("user",u);
            resp.sendRedirect(u.getRole().equals("ADMIN")?"admin.jsp":"dashboard.jsp");
        }catch(Exception e){throw new ServletException(e);}
    }
}
