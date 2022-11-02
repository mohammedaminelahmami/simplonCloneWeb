<%
    if(session.getAttribute("user") == null)
    {
        response.sendRedirect("apprenantLogin.jsp");
    }
%>
<h1>Welcome !!!!!!</h1>


<form action="/logout" method="post">
    <button type="submit">Logout</button>
</form>