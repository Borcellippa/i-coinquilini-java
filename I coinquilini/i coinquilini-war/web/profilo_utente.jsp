<%-- 
    Document   : utente
    Created on : 19-nov-2014, 17.03.07
    Author     : Bortignon Gianluca
--%>
<%@page import="ejb.coinquilini.users.Utente"%>
<%@include  file="topTemplateSideMenu.jsp" %>
<%  Gson gsonUtente = new Gson();
    String utenteFromJson = (request.getAttribute("utente")).toString();
    Utente utente = gsonUtente.fromJson(utenteFromJson, Utente.class);
%>
<div class="col-md-4">
    <h1>Questo � il profilo <%= utente.getEmail()%></h1>

    <form method="POST" action="UserController" role="form">
        <div class="form-group">
            <label for="nome">Nome</label>
            <input type="text" name="nome" class="form-control" required >
        </div>
        <div class="form-group">
            <label for="cognome">Cognome</label>
            <input type="text" name="cognome" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="telefono">Telefono</label>
            <input type="text" name="telefono" class="form-control" pattern="[0-9]*">
        </div>
        <div class="form-group">
            <label for="nazionalita">Nazionalit�</label>
            <input type="text" name="nazionalita" class="form-control">
        </div>
        <div class="form-group">
            <label for="data_nascita">Data di Nascita</label>
            <input name="data" class="form-control" placeholder="gg/mm/aaaa" data-provide="datepicker" data-date-format="dd/mm/yyyy" data-date-autoclose="true" required>
        </div>
        <div class="form-group">
            <label for="citta_natale">Citt� natale</label>
            <input type="text" name="citta_natale" class="form-control">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>

        <input type="hidden" name="action" value="addUtente">
    </form>
</div>
<div class="col-md-4"></div>
<%@include  file="botTemplateSideMenu.jsp" %>