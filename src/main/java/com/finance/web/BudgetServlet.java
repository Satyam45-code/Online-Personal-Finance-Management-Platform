package com.finance.web;

import com.finance.dao.BudgetDAO;
import com.finance.model.*;
import com.finance.service.FinanceService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/budget")
public class BudgetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        try{
            User u=(User)req.getSession().getAttribute("user");
            Budget b=new Budget(0,u.getId(),req.getParameter("category"),Double.parseDouble(req.getParameter("amount")),req.getParameter("duration"));
            new FinanceService().addBudget(b);
            resp.sendRedirect("budgets.jsp?msg=Budget+created");
        }catch(Exception e){resp.sendRedirect("budgets.jsp?error="+java.net.URLEncoder.encode(e.getMessage(),"UTF-8"));}
    }
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        try{new BudgetDAO().delete(Integer.parseInt(req.getParameter("id")));resp.sendRedirect("budgets.jsp?msg=Budget+deleted");}
        catch(Exception e){resp.sendRedirect("budgets.jsp?error=Delete+failed");}
    }
}
