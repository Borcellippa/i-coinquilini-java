<div class="jumbotron">
    <div class="container">
        <div class="col-md-10">
            <h1>I Coinquilini</h1>
            <p>Una piccola utility per la vita conviviale di tutti i giorni</p>            
        </div>
        <div class="col-md-2">
            <p>
                <%
                    String nomeAccount = (String) session.getAttribute("nome");
                    String tipoAccount = (String) session.getAttribute("tipoAccount");
                    if (nomeAccount != null) {
                %>
                Ciao <%=nomeAccount%>
                <form method="POST" action="UserController" role="form">
                    <input type="hidden" name="action" value="logout">
                    <button id="revokeButton" type="submit" class="btn btn-warning">Logout</button>
                </form>
                <% }%>
            </p>
        </div>



    </div>
</div>