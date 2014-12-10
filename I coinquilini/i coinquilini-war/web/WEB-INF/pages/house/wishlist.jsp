<%-- 
    Document   : utente
    Created on : 10-dic-2014, 11.34.46
    Author     : Bortignon Gianluca
--%>
<%@page import="borcellippa.coinquilini.casa.wishlist.wishlistentry.WishlistEntry"%>
<%@page import="java.util.List"%>
<%@page import="borcellippa.coinquilini.casa.wishlist.Wishlist"%>
<%@page import="borcellippa.coinquilini.users.utente.Utente"%>
<%@include  file="../templates/topTemplateSideMenu.jsp" %>
<script src="js/wishlist.js"></script>
<%  Gson gsonUtente = new Gson();
    String utenteFromJson = ((String) request.getAttribute("utente"));
    Utente utente = gsonUtente.fromJson(utenteFromJson, Utente.class);
    String pictureUrl = (String) session.getAttribute("url");
    String wFromJson = ((String) request.getAttribute("wishlist"));
    Wishlist w = gsonUtente.fromJson(wFromJson, Wishlist.class);
    List<WishlistEntry> we = w.getEntries();
%>

<div id="social-wizard" style="width: 656px">
    <header>
        <h1>Wishlist</h1>
    </header>
    <div class="wizard-content">
        <strong>
            <p>
                Ti serve qualcosa e non vuoi dimenticartene?
                Appuntalo subito nella lista della spesa!
            </p>
        </strong>
        <div class="container" style="margin-top:20px;">
            <div class="row">
                <div class="col-xs-6">
                    <div class="well">
                        <ul id="check-list-box" class="list-group checked-list-box">
                            <li class="list-group-item">Cras justo odio</li>
                            <li class="list-group-item" data-color="success">Dapibus ac facilisis in</li>
                            <li class="list-group-item" data-color="info">Morbi leo risus</li>
                            <li class="list-group-item" data-color="warning">Porta ac consectetur ac</li>
                            <li class="list-group-item" data-color="danger">Vestibulum at eros</li>
                        </ul>
                        <button class="btn btn-primary col-xs-12" id="get-checked-data">Get Checked Data</button>
                    </div>
                    <pre id="display-json"></pre>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include  file="../templates/botTemplateFree.jsp" %>
