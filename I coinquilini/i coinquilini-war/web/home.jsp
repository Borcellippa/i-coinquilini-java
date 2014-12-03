
<%-- 
    Document   : home
    Created on : 25-nov-2014, 11.20.53
    Author     : Bortignon Gianluca
--%>

<%@page import="com.google.gson.Gson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>I coinquilini</title>
        <%@include  file="imports.html" %>
        <script src="js/core/scrollspy.js"></script>
        <script src="js/facebookLogin.js"></script>
        <script src="js/utility.js"></script>
    </head>

    <script type="text/javascript">
        var gButtonClicked = false;

        function gButtonClick() {
            gButtonClicked = true;
        }

        (function() {
            var po = document.createElement('script');
            po.type = 'text/javascript';
            po.async = true;
            po.src = 'https://apis.google.com/js/client:plusone.js';
            var s = document.getElementsByTagName('script')[0];
            s.parentNode.insertBefore(po, s);
        })();

        function signinCallback(authResult) {
            if (gButtonClicked) {
                if (authResult['access_token']) {
                    // Autorizzazione riuscita
                    sendHTMLRequest("UserController", "post", "gLogin", authResult['access_token']);

                } else if (authResult['error']) {
                    // Si è verificato un errore.
                    // Possibili codici di errore:
                    //   "access_denied" - L'utente ha negato l'accesso alla tua app
                    //   "immediate_failed" - Impossibile eseguire l'accesso automatico dell'utente
                    console.log('There was an error: ' + authResult['error']);
                }
            }
        }
    </script>

    <body id="homepage-body">
        <div id="jumbotron" class="jumbotron">
            <div id="jumbotron-man" class="container">
                <h1 id="jumbotronLabel">Roommates</h1>
            </div>
        </div>
        <div id="jumbotron-top"></div>

        <div class="uk-grid" id="home-container" style="margin-left: 0px">
            <div class="uk-width-1-2" style="margin-right: 0px;padding-right: 1px">
                <div class="uk-overlay">
                    <img src="images/a.jpg" style="" class="homeImg" alt="">
                    <div class="uk-overlay-area">
                        <div class="uk-overlay-area-content lato-font">
                            Entra in casa e organizza la tua convivenza
                            <br/><br/>
                            <%
                                String tipoAccount = (String) session.getAttribute("tipoAccount");
                                if (tipoAccount != null && tipoAccount == "utente") {
                            %>
                            <form action="UserController" method="POST" role="form"><form>
                                    <button type="submit" class="btn btn-primary btn-lg">Entra</button>
                                    <input type="hidden" name="action" value="profilo_utente">
                                </form>
                                <% } else { %>
                                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#loginModal">
                                    Entra
                                </button>
                                <% }%>
                        </div>
                    </div>
                </div>
            </div>
            <div class="uk-width-1-2">
                <div class="uk-overlay">
                    <img src="images/b.jpg" style="margin-left: 0px;padding-left: 1px" class="homeImg" alt="">
                    <div class="uk-overlay-area">
                        <div class="uk-overlay-area-content lato-font">
                            Cerca facilmente una casa in base alle tue esigenze
                            <br/><br/>
                            <form action="AnnunciController" method="POST" role="form"><form>
                                    <button type="submit" class="btn btn-primary btn-lg">Entra</button>
                                    <input type="hidden" name="action" value="visualizza_annunci">
                                </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div id="home-motto">
                        Fare l'amore con te è stato come lanciare un salame in un corridoio

                        <%  // Gestione della stampa in caso di errore di login
                            Gson gsonErrore = new Gson();
                            String erroreFromJson = (String) request.getAttribute("errore");
                            if (erroreFromJson != null) {
                                String err = gsonErrore.fromJson(erroreFromJson, String.class);
                                if (err.equals("errore_login")) {
                        %>
                        <div class="alert alert-danger" role="alert"> Email o Password errate </div>
                        <%
                                }
                            }
                        %>
                    </div>
                </div>
                <hr class="soften">
                <div class="row" id="content">
                    <div class="col-md-4 home-component" data-uk-scrollspy="{cls:'uk-animation-fade', delay: 500}">
                        <div class="component-title">
                            <span class="glyphicon glyphicon-star" aria-hidden="true"></span> Semplifica la vita
                        </div>
                        <h4>
                            Devi organizzare una cena con dei tuoi amici? Dovrai comprare qualcosa e addebitare alle persone giuste le spese...<br/>Roommates ti aiuta a fare tutte queste cose!
                        </h4>
                    </div>
                    <div class="col-md-4 home-component" data-uk-scrollspy="{cls:'uk-animation-fade', delay: 1000}">
                        <div class="component-title">
                            <span class="glyphicon glyphicon-usd" aria-hidden="true"></span> Gestione economica
                        </div>
                        <h4>
                            Basta discussioni su debiti o crediti, la precisione con Roommates è al centesimo!
                        </h4>
                    </div>
                    <div class="col-md-4 home-component" data-uk-scrollspy="{cls:'uk-animation-fade', delay: 1500}">
                        <div class="component-title">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Mansioni
                        </div>
                        <h4>
                            A chi tocca questa settimana pulire il bagno? Gestisci i turni delle varie pulizie con facilità
                        </h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 home-component" data-uk-scrollspy="{cls:'uk-animation-fade', delay: 500}">
                        <div class="component-title">
                            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Wishlist
                        </div>
                        <h4>
                            Condividi cosa manca nella dispensa con i tuoi coinquilini e una volta comprato inserisci direttamente in borsellino le spese sostenute
                        </h4>
                    </div>
                    <div class="col-md-4 home-component" data-uk-scrollspy="{cls:'uk-animation-fade', delay: 1000}">
                        <div class="component-title">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span> Socializza
                        </div>
                        <h4>
                            Incontra e organizza feste con altre case tramite una bacheca e una wishlist condivisa
                        </h4>
                    </div>
                    <div class="col-md-4 home-component" data-uk-scrollspy="{cls:'uk-animation-fade', delay: 1500}">
                        <div class="component-title">
                            <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>&nbsp Promemoria
                        </div>
                        <h4>
                            L'idraulico viene a casa vostra domani pomeriggio? Ricordalo a tutti in modo che qualcuno sia sempre in casa
                        </h4>
                    </div>
                </div>
                <hr class="soften">
                <div class="row">
                    <p style="text-align: center">
                        &copy Borticelli SAP
                    </p>
                </div>
            </div>
        </div>
        <%@include  file="footer.html" %>



        <!-- MODAL -->
        <div class="modal fade" id="loginModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Login</h4>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-6">
                            <a class="btn btn-block btn-social btn-facebook" onclick="fb_login();">
                                <i class="uk-icon-facebook"></i> Sign in with Facebook
                            </a>
                        </div>
                        <div class="col-md-6">
                            <span id="signinButton" onclick="gButtonClick();">
                                <span
                                    class="g-signin"
                                    data-callback="signinCallback"
                                    data-clientid="702958319868-kj4pe0qgtdo34b9t150qsb318kfqulp7.apps.googleusercontent.com"
                                    data-cookiepolicy="single_host_origin"
                                    data-requestvisibleactions="http://schemas.google.com/AddActivity"
                                    data-scope="https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.email">
                                </span>
                            </span>
                            <!--<a class="btn btn-block btn-social btn-google-plus">
                                <i class="uk-icon-google-plus"></i> Sign in with Google+
                            </a>-->
                        </div>

                        <form action="UserController" id="loginForm" method="POST" role="form">
                            <div class="form-group">
                                <label for="email" style="margin-top: 15px;">Email address</label>
                                <input class="form-control" type="text" name="email" id="email" placeholder="Email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input class="form-control" type="password" name="password" id="password" placeholder="Password" required>
                            </div>
                            <input type="hidden" name="action" value="login">
                        </form>

                        <form action="UserController" id="registrazioneForm" method="POST" role="form">
                            <input type="hidden" name="action" value="registrazione">
                        </form>

                        <button class="btn btn-primary" onclick="$('#loginForm').submit();">Login</button>
                        <button type="submit" class="btn btn-default" onclick="$('#registrazioneForm').submit();">Registrazione</button>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>
</html>
