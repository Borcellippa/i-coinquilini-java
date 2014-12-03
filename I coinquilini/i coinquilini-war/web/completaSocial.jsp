<%@page import="ejb.coinquilini.users.Utente"%>
<%@include  file="topTemplateFree.jsp" %>

<%  Gson gsonUtente = new Gson();
    String utenteFromJson = ((String) request.getAttribute("utente"));
    Utente utente = gsonUtente.fromJson(utenteFromJson, Utente.class);
%>

<div class="col-md-4"></div>
<div class="col-md-4">
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
            <label for="password">Password</label>
            <input type="password" name="password" required class="form-control">
        </div>
        <div class="form-group">
            <label for="passwordConf">Conferma Password</label>
            <input type="passwordConf" name="passwordConf" required class="form-control">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>

        <input type="hidden" name="action" value="completeFacebook">
    </form>
</div>
<div class="col-md-4"></div>
<%@include  file="botTemplateFree.jsp" %>