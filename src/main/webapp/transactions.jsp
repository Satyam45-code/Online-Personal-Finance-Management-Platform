<%@ page import="com.finance.model.User,com.finance.model.Transaction,com.finance.dao.TransactionDAO,java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% User user=(User)session.getAttribute("user"); if(user==null){response.sendRedirect("login.jsp");return;} List<Transaction> list=new TransactionDAO().findAll(user.getId()); %>
<!DOCTYPE html><html><head><title>Transactions | Finora</title><link rel="stylesheet" href="css/style.css"></head><body><div class="layout">
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
<div class="topbar"><div><h1>Transactions</h1><div class="muted">Your personal expense history.</div></div><a class="btn" href="#add">+ Add expense</a></div>
<%if(request.getParameter("msg")!=null){%><div class="alert"><%=request.getParameter("msg")%></div><%}%>
<%if(request.getParameter("error")!=null){%><div class="alert error"><%=request.getParameter("error")%></div><%}%>
<div class="two">
<div class="card"><h2>Expense history</h2><table><tr><th>Category</th><th>Amount</th><th>Date</th><th>Description</th><th></th></tr>
<%for(Transaction t:list){%><tr><td><span class="tag"><%=t.getCategory()%></span></td><td>₹ <%=String.format("%,.2f",t.getAmount())%></td><td><%=t.getDate()%></td><td><%=t.getDescription()==null?"":t.getDescription()%></td><td><a class="btn danger" href="transaction?id=<%=t.getId()%>">Delete</a></td></tr><%}%>
</table></div>
<div class="card" id="add"><h2>Add expense</h2><form action="transaction" method="post">
<input name="amount" type="number" step="0.01" placeholder="Amount (₹)" required>
<select name="category"><option>Food</option><option>Travel</option><option>Shopping</option><option>Education</option><option>Bills</option><option>Health</option><option>Other</option></select>
<input name="date" type="date" required>
<input name="description" placeholder="Description">
<button class="btn">Save expense</button></form></div>
</div></div></div></body></html>
