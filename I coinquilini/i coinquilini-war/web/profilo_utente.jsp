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

<% if (utente.getFb_user_id() != null) {%>    
<h3>
    <%=utente.getFb_user_id()%>
</h3>
<% } %>
<form method="POST" action="UserController" role="form">
    <div class="row">
        <div class="col-md-3">
            <img src="images/user.png" class="img-thumbnail" width="100%">
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-4">
            <div class="row">
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" class="form-control" required value='<%if (utente.getNome() != null) {
                            out.println(utente.getNome());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="cognome">Cognome</label>
                    <input type="text" name="cognome" class="form-control" required value='<%if (utente.getCognome() != null) {
                            out.println(utente.getCognome());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" name="email" class="form-control" required readonly value='<%if (utente.getEmail() != null) {
                            out.println(utente.getEmail());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="radio">
                    <label>
                        <input type="radio" name="genere" id="male" value="male" checked>
                        Uomo
                    </label>&nbsp&nbsp&nbsp&nbsp&nbsp
                    <label>
                        <input type="radio" name="genere" id="female" value="female">
                        Donna
                    </label>
                </div>
            </div>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-3">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Aggiorna password
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="passwordOld">Vecchia Password</label>
                                    <input type="text" name="passwordOld" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="passwordNew">Nuova Password</label>
                                    <input type="password" name="passwordNew" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="passwordConf">Conferma Password</label>
                                    <input type="password" name="passwordConf" class="form-control">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-4">
            <div class="row">
                <div class="form-group">
                    <label for="telefono">Telefono</label>
                    <input type="text" name="telefono" class="form-control" pattern="[0-9]*" value='<%if (utente.getTelefono() != null) {
                            out.println(utente.getTelefono());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="nazionalita">Nazionalità</label>
                    <input type="text" name="nazionalita" class="form-control" value='<%if (utente.getNazionalita() != null) {
                            out.println(utente.getNazionalita());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="data_nascita">Data di Nascita</label>
                    <input name="data_nascita" class="form-control" placeholder="gg/mm/aaaa" data-provide="datepicker" data-date-format="dd/mm/yyyy" data-date-autoclose="true" required value='<%if (utente.getData_nascita() != null) {
                            out.println(utente.getData_nascita());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="citta_natale">Città natale</label>
                    <input type="text" name="citta_natale" class="form-control" value='<%if (utente.getCitta_natale() != null) {
                            out.println(utente.getCitta_natale());
                        }%>'>
                </div>
            </div>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4" style="text-align: right">
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>

        <input type="hidden" name="action" value="editUtente">
    </div>
</form>
<div class="col-md-4"></div>
<%@include  file="botTemplateSideMenu.jsp" %>