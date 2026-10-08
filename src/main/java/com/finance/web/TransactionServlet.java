package com.finance.web;

import com.finance.model.*;
import com.finance.dao.TransactionDAO;
import com.finance.service.FinanceService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/transaction")
public class TransactionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        try{
            User u=(User)req.getSession().getAttribute("user");
            Transaction t=new Transaction(0,u.getId(),req.getParameter("category"),
                    Double.parseDouble(req.getParameter("amount")),
                    LocalDate.parse(req.getParameter("date")),req.getParameter("description"));
            new FinanceService().addTransaction(t);
            resp.sendRedirect("transactions.jsp?msg=Expense+added+successfully");
        }catch(Exception e){resp.sendRedirect("transactions.jsp?error="+java.net.URLEncoder.encode(e.getMessage(),"UTF-8"));}
    }
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        try{new TransactionDAO().delete(Integer.parseInt(req.getParameter("id")));resp.sendRedirect("transactions.jsp?msg=Expense+deleted");}
        catch(Exception e){resp.sendRedirect("transactions.jsp?error=Delete+failed");}
    }
}
