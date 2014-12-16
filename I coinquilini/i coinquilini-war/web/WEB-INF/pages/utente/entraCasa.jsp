<%-- 
    Document   : utente
    Created on : 09-dic-2014, 19.23.46
    Author     : Bortignon Gianluca
--%>
<%@page import="borcellippa.coinquilini.utente.Utente"%>
<%@include  file="../templates/topTemplateFree.jsp" %>
<%  Gson gsonUtente = new Gson();
    String utenteFromJson = ((String) request.getAttribute("utente"));
    Utente utente = gsonUtente.fromJson(utenteFromJson, Utente.class);
    String pictureUrl = (String) session.getAttribute("url");
%>

<div id="social-wizard" style="width: 950px">
    <header>
        <h1>Sembra che tu non faccia ancora parte di nessuna casa</h1>
    </header>
    <div class="wizard-content">
        <p>
            Scegli ora se entrare in una <strong>casa esistente</strong> o <strong>creane una</strong>!
        </p>

        <section id="account-password" class="entra-casa">
            <div id="leftContainer" class="menu-container">
                <div id="leftPasswordDiv">
                    <img src="images/search.png" style="height: 100px; margin-top: 45px; margin-left: 35px">
                </div>
                <div id="rightPasswordDiv">
                    <form method="POST" action="CasaController" role="form" style="margin-left: 20px;" onsubmit="return checkForm(this);">
                        <div class="content">
                            <div>
                                <label style="width: 195px">Entra in una casa esistente</label>
                                <input id="nomeCasa" type="text" name="codiceCasa" placeholder="Inserisci il codice della casa" required class="form-control inputForm" onfocus="removeError()">
                            </div>
                        </div>
                        <div class="form-group"  style="margin-top: 15px;text-align: center">
                            <button type="submit" class="btn btn-lg custom-button">Entra</button>
                        </div>
                        <input type="hidden" name="action" value="entraInCasa">
                    </form>
                </div>
            </div>
            <div id="rightContainer" class="menu-container">
                <div id="leftPasswordDiv">
                    <img src="images/house.png" style="height: 100px; margin-top: 45px; margin-left: 35px">
                </div>
                <div id="rightPasswordDiv">
                    <form method="POST" action="CasaController" role="form" style="margin-left: 20px;">
                        <div class="form-group"  style="margin-top: 15px;text-align: center">
                            <strong> Creare una casa è semplice! </strong>
                            <button type="submit" class="btn btn-lg custom-button" style="margin-top: 36px">Crea ora</button>
                        </div>
                        <input type="hidden" name="action" value="creaCasa">
                    </form>
                </div>
            </div>
        </section>
        <%  // Gestione della stampa in caso di inserimento di un codice casa inesistente
            Gson gsonErrore = new Gson();
            String erroreFromJson = (String) request.getAttribute("errore");
            String errore = null;
            if (erroreFromJson != null) {
                String err = gsonErrore.fromJson(erroreFromJson, String.class);
                if (err.equals("casa_assente")) {
                    errore = "Il codice della casa è inesistente";
                }
                if (err.equals("utente_inquilino")) {
                    errore = "Vivi già in una casa!";
                }
            }

            if (errore != null) {
        %>
        <div class="alert alert-danger" role="alert"> <%=errore%> </div>

        <%
            }%>
    </div>
</div>

<%@include  file="../templates/botTemplateFree.jsp" %>
