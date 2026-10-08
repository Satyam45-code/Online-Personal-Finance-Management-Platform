<%@ page import="com.finance.model.User,com.finance.model.Goal,com.finance.dao.GoalDAO,java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% User user=(User)session.getAttribute("user"); if(user==null){response.sendRedirect("login.jsp");return;} List<Goal> list=new GoalDAO().findAll(user.getId()); %>
<!DOCTYPE html><html><head><title>Goals | Finora</title><link rel="stylesheet" href="css/style.css"></head><body><div class="layout">
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

<div class="main"><div class="topbar"><div><h1>Financial Goals</h1><div class="muted">Build toward what matters.</div></div></div>
<%if(request.getParameter("msg")!=null){%><div class="alert"><%=request.getParameter("msg")%></div><%}%>
<div class="two"><div class="card"><h2>Your goals</h2><%for(Goal g:list){double p=Math.min(100,g.getProgress());%><div style="padding:16px 0;border-bottom:1px solid #edf0f5"><div style="display:flex;justify-content:space-between"><b><%=g.getDescription()%></b><a href="goal?id=<%=g.getId()%>">Delete</a></div><p class="muted">₹ <%=String.format("%,.2f",g.getSavedAmount())%> saved of ₹ <%=String.format("%,.2f",g.getTargetAmount())%></p><div class="progress"><div class="bar" style="width:<%=p%>%"></div></div><small class="muted"><%=String.format("%.0f",p)%>% · deadline <%=g.getDeadline()%></small></div><%}%></div>
<div class="card"><h2>Set a goal</h2><form action="goal" method="post"><input name="description" placeholder="Goal description" required><input name="target" type="number" step="0.01" placeholder="Target amount" required><input name="saved" type="number" step="0.01" value="0" placeholder="Already saved"><input name="deadline" type="date" required><button class="btn">Create goal</button></form></div>
</div></div></div></body></html>
