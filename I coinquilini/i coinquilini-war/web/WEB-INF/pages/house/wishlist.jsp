<%-- 
    Document   : utente
    Created on : 10-dic-2014, 11.34.46
    Author     : Bortignon Gianluca
--%>
<%@page import="borcellippa.coinquilini.casa.wishlist.wishlistentry.WishlistEntry"%>
<%@page import="java.util.List"%>
<%@page import="borcellippa.coinquilini.casa.wishlist.Wishlist"%>
<%@page import="borcellippa.coinquilini.utente.Utente"%>
<%@include  file="../templates/topTemplateSideMenu.jsp" %>
<script src="js/wishlist.js"></script>
<%  Gson gsonUtente = new Gson();
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
                        <ul id="check-list-box" class="list-group checked-list-box wishlist-entry">
                            <% if (we != null) {
                                    for (WishlistEntry entry : we) {%>
                                        <li class="list-group-item">
                                            <div class="uk-grid wishlist-li">
                                                <div class="uk-width-8-10 wishlist-li-left">
                                                    <%= entry.getDescrizione()%>
                                                </div>
                                                <div class="uk-width-2-10 wishlist-li-right">
                                                    <div class="entry-container">
                                                        <label class="wishlist-entry-label"><%= entry.getQuantita()%></label>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                            <%      }
                                }
                            else{ %>
                            <p style="margin-bottom: 45px;"> Sembra che la lista della spesa sia vuota...Crea ora una nuova voce! </p>
                            <% } %>
                        </ul>

                        <button type="button" class="btn btn-lg custom-button" data-toggle="modal" data-target="#wishlistEntryModal">
                            Crea nuova voce
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include  file="../templates/botTemplateFree.jsp" %>


<!-- MODAL -->
<div class="modal fade" id="wishlistEntryModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title"><b>Crea nuova voce</b></h4>
            </div>
            <div class="modal-body">
                <div id="loginDiv">
                    <form action="WishlistController" id="wishlistEntryForm" method="POST" role="form">
                        <div class="form-group">
                            <label for="descrizione" style="margin-top: 15px;">Descrizione</label>
                            <input class="form-control" type="text" name="descrizione" id="descrizione" placeholder="Inserire la descrizione..." required>
                        </div>
                        <div class="form-group">
                            <label for="quantita">Quantità</label>
                            <input class="form-control" type="number" min="0.1" step="0.1" name="quantita" id="quantita" required>
                        </div>
                        <input type="hidden" name="action" value="creaEntryWishlist">
                    </form>
                </div>

                <div id="submitDiv" style="margin-top: 30px">
                    <button class="btn btn-lg custom-button" onclick="$('#wishlistEntryForm').submit();">Crea voce</button>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
