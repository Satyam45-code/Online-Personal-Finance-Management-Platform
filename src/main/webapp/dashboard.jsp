<%@ page import="com.finance.model.User,com.finance.dao.TransactionDAO,com.finance.dao.BudgetDAO,com.finance.dao.GoalDAO,java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
User user=(User)session.getAttribute("user"); if(user==null){response.sendRedirect("login.jsp");return;}
List<?> tx=new TransactionDAO().findAll(user.getId()); List<?> budgets=new BudgetDAO().findAll(user.getId()); List<?> goals=new GoalDAO().findAll(user.getId());
double total=0; for(Object o:tx) total+=((com.finance.model.Transaction)o).getAmount();
%>
<!DOCTYPE html><html><head><title>Dashboard | Finora</title><link rel="stylesheet" href="css/style.css"></head><body>
<div class="layout">
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

<div class="main">
<div class="topbar"><div><h1>Good to see you, <%=user.getName()%> 👋</h1><div class="muted">Here’s your financial snapshot.</div></div><div class="userpill"><%=user.getRole()%></div></div>
<div class="hero"><div class="label" style="color:#e5e8ff">TOTAL TRACKED EXPENSES</div><div class="stat">₹ <%=String.format("%,.2f",total)%></div><div style="margin-top:8px;opacity:.85">Keep every rupee visible.</div></div>
<div class="grid">
<div class="card"><div class="icon">↕</div><div class="stat"><%=tx.size()%></div><div class="label">Transactions</div></div>
<div class="card"><div class="icon">▣</div><div class="stat"><%=budgets.size()%></div><div class="label">Active Budgets</div></div>
<div class="card"><div class="icon">◎</div><div class="stat"><%=goals.size()%></div><div class="label">Financial Goals</div></div>
<div class="card"><div class="icon">✓</div><div class="stat">Secure</div><div class="label">Account Status</div></div>
</div>
<div class="three">
<div class="card"><h2>Expenses</h2><p class="muted">Track and categorize every expense.</p><a class="btn" href="transactions.jsp">Manage expenses</a></div>
<div class="card"><h2>Budgets</h2><p class="muted">Set limits and control spending.</p><a class="btn" href="budgets.jsp">Manage budgets</a></div>
<div class="card"><h2>Goals</h2><p class="muted">Turn plans into measurable progress.</p><a class="btn" href="goals.jsp">Manage goals</a></div>
</div>
</div></div></body></html>
