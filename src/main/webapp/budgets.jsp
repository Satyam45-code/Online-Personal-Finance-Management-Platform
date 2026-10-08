<%@ page import="com.finance.model.User,com.finance.model.Budget,com.finance.dao.BudgetDAO,java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% User user=(User)session.getAttribute("user"); if(user==null){response.sendRedirect("login.jsp");return;} List<Budget> list=new BudgetDAO().findAll(user.getId()); %>
<!DOCTYPE html><html><head><title>Budgets | Finora</title><link rel="stylesheet" href="css/style.css"></head><body><div class="layout">
<div class="sidebar">
  <div class="brand">Fin<span>ora</span></div>
  <div class="nav">
    <a href="dashboard.jsp">⌂ Dashboard</a>
    <a href="transactions.jsp">↕ Transactions</a>
    <a href="budgets.jsp">▣ Budgets</a>
    <a href="goals.jsp">◎ Financial Goals</a>
    <a href="logout">⇥ Logout</a>
  </div>
</div>

<div class="main"><div class="topbar"><div><h1>Budgets</h1><div class="muted">Give every category a spending boundary.</div></div></div>
<%if(request.getParameter("msg")!=null){%><div class="alert"><%=request.getParameter("msg")%></div><%}%>
<div class="two"><div class="card"><h2>Your budgets</h2><%for(Budget b:list){%><div style="padding:14px 0;border-bottom:1px solid #edf0f5"><div style="display:flex;justify-content:space-between"><b><%=b.getCategory()%></b><span>₹ <%=String.format("%,.2f",b.getAmount())%></span></div><div class="progress" style="margin:10px 0"><div class="bar" style="width:35%"></div></div><small class="muted"><%=b.getDuration()%> · progress visual</small> <a style="float:right" href="budget?id=<%=b.getId()%>">Delete</a></div><%}%></div>
<div class="card"><h2>Create budget</h2><form action="budget" method="post"><select name="category"><option>Food</option><option>Travel</option><option>Shopping</option><option>Education</option><option>Bills</option><option>Health</option><option>Other</option></select><input name="amount" type="number" step="0.01" placeholder="Budget amount" required><select name="duration"><option>Monthly</option><option>Weekly</option><option>Yearly</option></select><button class="btn">Create budget</button></form></div>
</div></div></div></body></html>
