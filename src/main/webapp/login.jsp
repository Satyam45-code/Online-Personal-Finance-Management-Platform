<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html><head><title>Finora Login</title><link rel="stylesheet" href="css/style.css"></head>
<body class="login">
<div class="loginbox">
    <div class="brand">Fin<span>ora</span></div>
    <h1>Welcome back</h1>
    <p class="muted">Manage your money with clarity and confidence.</p>
    <% if(request.getAttribute("error")!=null){ %><div class="alert error"><%=request.getAttribute("error")%></div><% } %>
    <form action="login" method="post">
        <input type="email" name="email" placeholder="Email address" required>
        <input type="password" name="password" placeholder="Password" required>
        <button class="btn" type="submit">Sign in</button>
    </form>
    <p class="muted" style="margin-top:18px;font-size:12px">Demo: satyam@gmail.com / 1234</p>
</div>
</body></html>
