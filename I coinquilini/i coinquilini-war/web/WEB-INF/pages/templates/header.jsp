<%@page import="borcellippa.coinquilini.casa.casa.Casa"%>
<%@page import="borcellippa.coinquilini.utente.Utente"%>
<%@page import="com.google.gson.Gson"%>
<div class="top-navbar">
    <div class="col-md-4">
        <a href="UserController?action=home" style="color: white;text-decoration: none;">
            <div class="col-md-4" style="margin-top: 2px;">
                <img src="images/a.jpg" class="img-circle img-thumbnail" height="140px" width="140px">
            </div> 
            <h1 style="color: white">Roommates</h1>
        </a>
    </div>
    <div class="col-md-4">
        <%
            Gson gsonCasaHeader = new Gson();
            String casaFromJsonHeader = ((String) request.getAttribute("casa"));
            Casa casaHeader = gsonCasaHeader.fromJson(casaFromJsonHeader, Casa.class);
            if (casaHeader != null) {
        %>
        <div id="header-central">
            <h2 id="nome-casa-header"><%= casaHeader.getNomeCasa()%></h2>
            <p id="codice-casa-header">Cod: <%= casaHeader.getCodiceCasa()%></p>
        </div>
        <% } %>
    </div>
    <div class="col-md-4">
        <div class="col-md-3"></div>
        <%
            String url = (String) session.getAttribute("url");
            String nomeAccount = (String) session.getAttribute("nome");
            if (nomeAccount != null) {
        %>
        <div class="col-md-4">
            <img src="<%= url%>" class="img-thumbnail" id="userPicture" height="70px" width="70px" style="margin-top: 10px; float: right">
        </div>
        <div class="col-md-5" style="overflow-x: hidden">
            <p style="color: white; font-weight: bold; margin-top: 12px; font-size: large;">
                Ciao <%=nomeAccount%> !
            </p>
            <form method="POST" action="UserController" role="form">
                <input type="hidden" name="action" value="logout">
                <button id="revokeButton" type="submit" class="btn btn-warning btn-sm" style="margin-top: -2px;">Logout</button>
            </form>
        </div>
        <% }%>
    </div>
</div>
