<%@page import="borcellippa.coinquilini.utente.Utente"%>
<%@page import="com.google.gson.Gson"%>

<%
    Gson gsonLocation = new Gson();
    String location = "";
    if (request.getAttribute("location") != null) {
        String loc = request.getAttribute("location").toString();
        location = gsonLocation.fromJson(loc, String.class);
    }
%>


<div class="container" id="sidemenu">
        <div class="col-sm-3 col-md-3">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading sidebar-panel">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                            <h4 class="panel-title">
                                <span class="glyphicon glyphicon-home">
                                </span>La mia casa
                            </h4>
                        </a>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse
                         <% if (location.equals("bacheca") || location.equals("profilo_casa") || location.equals("wishlist")) {
                                 out.print("in");
                             }%>">
                        <div class="panel-body">
                            <table class="table">
                                <tr class="<% if (location.equals("bacheca")) out.print("active"); %>">
                                    <td class="sidebar-td">
                                        <span class="glyphicon glyphicon-comment text-success"></span><a href="BachecaController?action=getBacheca">Bacheca</a>
                                        <span class="badge">42</span>
                                    </td>
                                </tr>
                                <tr class="<% if (location.equals("profilo_casa")) out.print("active"); %>">
                                    <td>
                                        <span class="glyphicon glyphicon-pencil"></span><a href="CasaController?action=profilo_casa">Profilo casa</a>
                                    </td>
                                </tr>
                                <tr class="<% if (location.equals("wishlist")) out.print("active"); %>">
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt text-primary"></span><a href="WishlistController?action=getWishlist">Lista della spesa</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading sidebar-panel">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                            <h4 class="panel-title">
                                <span class="glyphicon glyphicon-bookmark">
                                </span>I miei impegni
                            </h4>
                        </a>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse
                         <% if (location.equals("calendario") || location.equals("promemoria") || location.equals("mansioni")) {
                                 out.print("in");
                             }%>">
                        <div class="panel-body">
                            <table class="table">
                                <tr class="<% if (location.equals("calendario")) out.print("active"); %>">
                                    <td>
                                        <span class="glyphicon glyphicon-calendar text-success"></span><a href="#Calendatio">Calendario</a>
                                    </td>
                                </tr>
                                <tr class="<% if (location.equals("promemoria")) out.print("active"); %>">
                                    <td>
                                        <span class="glyphicon glyphicon-pushpin text-alert"></span><a href="#Promemoria">Promemoria</a>
                                    </td>
                                </tr>
                                <tr class="<% if (location.equals("mansioni")) out.print("active"); %>">
                                    <td>
                                        <span class="glyphicon glyphicon-wrench text-danger"></span><a href="#Mansioni">Mansioni</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading sidebar-panel">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                            <h4 class="panel-title">
                                <span class="glyphicon glyphicon-euro">
                                </span>Le mie spese
                            </h4>
                        </a>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse
                         <% if (location.equals("debiti") || location.equals("borsellino")) {
                                 out.print("in");
                             }%>">
                        <div class="panel-body">
                            <table class="table">
                                <tr class="<% if (location.equals("debiti")) out.print("active"); %>">
                                    <td>
                                        <span class="glyphicon glyphicon-send text-alert"></span><a href="#Debiti">Debiti</a>
                                    </td>
                                </tr>
                                <tr class="<% if (location.equals("borsellino")) out.print("active"); %>">
                                    <td>
                                        <span class="glyphicon glyphicon-print text-success"></span><a href="#Borsellino">Borsellino</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading sidebar-panel">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                            <h4 class="panel-title">
                                <span class="glyphicon glyphicon-user">
                                </span>Account
                            </h4>
                        </a>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse
                         <% if (location.equals("profilo_utente")) {
                                 out.print("in");
                             }%>">
                        <div class="panel-body">
                            <table class="table">
                                <tr class="<% if (location.equals("profilo_utente")) out.print("active"); %>">
                                    <td>
                                        <span class="glyphicon glyphicon-cog"></span><a href="UserController?action=profilo_utente">Il mio profilo</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>