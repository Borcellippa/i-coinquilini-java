<div class="jumbotron">
    <div class="container">
        <h1>I Coinquilini</h1>
        <p>Una piccola utility per la vita conviviale di tutti i giorni</p>
       
        <% 
        String nomeAccount = (String)session.getAttribute("nome");
        String tipoAccount = (String)session.getAttribute("tipoAccount");
        if(nomeAccount != null) {
        %>
        <p>
                Ciao <%=nomeAccount %>
        </p>
        <% } %>

        
        
    </div>
</div>