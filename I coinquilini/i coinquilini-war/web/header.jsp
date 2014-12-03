<div style="background-color: cadetblue; height: 90px; margin-bottom: 25px">
    <div class="col-md-8">
        <div class="col-md-2" style="margin-top: 7px">
            <img src="images/a.jpg" class="img-circle img-thumbnail" height="140px" width="140px">
        </div>
        <h1 style="color: white">Roommates</h1>
    </div>
    <div class="col-md-4">
        <div class="col-md-3"></div>
        <div class="col-md-4">
            <img src="images/user.png" class="img-thumbnail" height="70px" width="70px" style="margin-top: 10px; float: right">
        </div>
        <div class="col-md-5">
            <p style="color: white; font-weight: bold; margin-top: 12px; font-size: large;">
                <%
                    String nomeAccount = (String) session.getAttribute("nome");
                    if (nomeAccount != null) {
                %>
                Ciao <%=nomeAccount%> !
            </p>
            <form method="POST" action="UserController" role="form">
                <input type="hidden" name="action" value="logout">
                <button type="submit" class="btn btn-warning btn-sm" style="margin-top: -2px;">Logout</button>
            </form>
        </div>
        <% }%>
        </p>
    </div>
</div>