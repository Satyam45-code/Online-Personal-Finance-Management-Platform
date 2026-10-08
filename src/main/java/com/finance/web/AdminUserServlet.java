package com.finance.web;

import com.finance.dao.UserDAO;
import com.finance.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/user")
public class AdminUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        try{
            User u=new User(0,req.getParameter("name"),req.getParameter("email"),req.getParameter("password"),
                    req.getParameter("role"),"ACTIVE");
            new UserDAO().save(u);
            resp.sendRedirect("../admin.jsp?msg=User+created");
        }catch(Exception e){resp.sendRedirect("../admin.jsp?error=Could+not+create+user");}
    }
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        try{new UserDAO().delete(Integer.parseInt(req.getParameter("id")));resp.sendRedirect("../admin.jsp?msg=User+deleted");}
        catch(Exception e){resp.sendRedirect("../admin.jsp?error=Delete+failed");}
    }
}
