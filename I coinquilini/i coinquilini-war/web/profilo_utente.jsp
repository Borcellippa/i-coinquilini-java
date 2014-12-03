<%-- 
    Document   : utente
    Created on : 19-nov-2014, 17.03.07
    Author     : Bortignon Gianluca
--%>
<%@page import="ejb.coinquilini.users.Utente"%>
<%@include  file="topTemplateSideMenu.jsp" %>
<%  Gson gsonUtente = new Gson();
    String utenteFromJson = ((String) request.getAttribute("utente"));
    Utente utente = gsonUtente.fromJson(utenteFromJson, Utente.class);
%>

<div class="col-md-4"></div>
<div class="col-md-4">
    <% if (utente.getFb_user_id() != null) {%>    
    <h3>
        <%=utente.getFb_user_id()%>
    </h3>
    <% } %>
    <form method="POST" action="UserController" role="form">
        <div class="form-group">
            <label for="nome">Nome</label>
            <input type="text" name="nome" class="form-control" required value='<%if (utente.getNome() != null) {
                    out.println(utente.getNome());
                }%>'>
        </div>
        <div class="form-group">
            <label for="cognome">Cognome</label>
            <input type="text" name="cognome" class="form-control" required value='<%if (utente.getCognome() != null) {
                    out.println(utente.getCognome());
                }%>'>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" class="form-control" required readonly value='<%if (utente.getEmail() != null) {
                    out.println(utente.getEmail());
                }%>'>
        </div>
        <div class="form-group">
            <label for="passwordOld">Vecchia Password</label>
            <input type="passwordOld" name="passwordOld" class="form-control">
        </div>
        <div class="form-group">
            <label for="passwordNew">Nuova Password</label>
            <input type="passwordNew" name="passwordNew" class="form-control">
        </div>
        <div class="form-group">
            <label for="passwordConf">Conferma Password</label>
            <input type="passwordConf" name="passwordConf" class="form-control">
        </div>
        <div class="form-group">
            <label for="telefono">Telefono</label>
            <input type="text" name="telefono" class="form-control" pattern="[0-9]*" value='<%if (utente.getTelefono() != null) {
                    out.println(utente.getTelefono());
                }%>'>
        </div>
        <div class="form-group">
            <label for="nazionalita">Nazionalità</label>
            <input type="text" name="nazionalita" class="form-control" value='<%if (utente.getNazionalita() != null) {
                    out.println(utente.getNazionalita());
                }%>'>
        </div>
        <div class="form-group">
            <label for="data_nascita">Data di Nascita</label>
            <input name="data_nascita" class="form-control" placeholder="gg/mm/aaaa" data-provide="datepicker" data-date-format="dd/mm/yyyy" data-date-autoclose="true" required value='<%if (utente.getData_nascita() != null) {
                    out.println(utente.getData_nascita());
                }%>'>
        </div>
        <div class="form-group">
            <label for="citta_natale">Città natale</label>
            <input type="text" name="citta_natale" class="form-control" value='<%if (utente.getCitta_natale() != null) {
                    out.println(utente.getCitta_natale());
                }%>'>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>

        <input type="hidden" name="action" value="editUtente">
    </form>
</div>
<div class="col-md-4"></div>
<%@include  file="botTemplateSideMenu.jsp" %>