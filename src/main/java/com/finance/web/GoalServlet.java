package com.finance.web;

import com.finance.dao.GoalDAO;
import com.finance.model.*;
import com.finance.service.FinanceService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/goal")
public class GoalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        try{
            User u=(User)req.getSession().getAttribute("user");
            Goal g=new Goal(0,u.getId(),req.getParameter("description"),Double.parseDouble(req.getParameter("target")),
                    Double.parseDouble(req.getParameter("saved")),LocalDate.parse(req.getParameter("deadline")));
            new FinanceService().addGoal(g);
            resp.sendRedirect("goals.jsp?msg=Goal+created");
        }catch(Exception e){resp.sendRedirect("goals.jsp?error="+java.net.URLEncoder.encode(e.getMessage(),"UTF-8"));}
    }
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        try{new GoalDAO().delete(Integer.parseInt(req.getParameter("id")));resp.sendRedirect("goals.jsp?msg=Goal+deleted");}
        catch(Exception e){resp.sendRedirect("goals.jsp?error=Delete+failed");}
    }
}
