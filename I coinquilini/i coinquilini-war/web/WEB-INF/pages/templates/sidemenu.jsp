<%@page import="borcellippa.coinquilini.utente.Utente"%>
<%@page import="com.google.gson.Gson"%>


<div class="container" id="sidemenu">
    <div class="row">
        <div class="col-sm-3 col-md-3">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><span class="glyphicon glyphicon-home">
                            </span>La mia casa</a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-comment text-success"></span><a href="http://www.jquery2dotnet.com">Bacheca</a>
                                        <span class="badge">42</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-paperclip text-success"></span><a href="http://www.jquery2dotnet.com">Profilo casa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt text-primary"></span><a href="http://www.jquery2dotnet.com">Lista della spesa</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"><span class="glyphicon glyphicon-bookmark">
                            </span>I miei impegni</a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-calendar text-success"></span><a href="http://www.jquery2dotnet.com">Calendario</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-pushpin text-alert"></span><a href="http://www.jquery2dotnet.com">Promemoria</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-wrench text-danger"></span><a href="http://www.jquery2dotnet.com">Mansioni</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"><span class="glyphicon glyphicon-euro">
                            </span>Le mie spese</a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-send text-alert"></span><a href="http://www.jquery2dotnet.com">Debiti</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-print text-success"></span><a href="http://www.jquery2dotnet.com">Borsellino</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour"><span class="glyphicon glyphicon-user">
                            </span>Account</a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-cog"></span><a href="http://www.jquery2dotnet.com">Il mio profilo</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="list-group" id="sidemenu">
    <%
        Gson gsonLocation = new Gson();
        String location = "";
        if (request.getAttribute("location") != null) {
            String loc = request.getAttribute("location").toString();
            location = gsonLocation.fromJson(loc, String.class);
        }
    %>
    
    <a href="BachecaController?action=getBacheca" class="list-group-item
       <% if (location.equals("bacheca")) out.print("active"); %>">Bacheca</a>
    <a href="#" class="list-group-item<% if (location.equals("coinquilini")) out.print("active"); %>
       ">Profilo casa</a>
    <a href="#" class="list-group-item
       <% if (location.equals("eventi")) out.print("active"); %>">Eventi</a>
    <a href="#" class="list-group-item
       <% if (location.equals("calendario")) out.print("active"); %>">&nbsp&nbsp Calendario</a>
    <a href="#" class="list-group-item
       <% if (location.equals("promemoria")) out.print("active"); %>">&nbsp&nbsp Promemoria</a>
    <a href="#" class="list-group-item
       <% if (location.equals("mansioni")) out.print("active"); %>">&nbsp&nbsp Mansioni</a>
    <a href="#" class="list-group-item
       <% if (location.equals("borsellino")) out.print("active"); %>">Borsellino</a>
    <a href="WishlistController?action=getWishlist" class="list-group-item
       <% if (location.equals("wishlist")) out.print("active"); %>">&nbsp&nbsp Wishlist</a>
    <a href="#" class="list-group-item
       <% if (location.equals("le_mie_spese")) out.print("active"); %>">&nbsp&nbsp Le mie spese</a>
    <a href="#" class="list-group-item
       <% if (location.equals("debiti")) out.print("active"); %>">&nbsp&nbsp Debiti</a>
    <a href="#" class="list-group-item
       <% if (location.equals("opzioni")) out.print("active"); %>">Opzioni</a>
    <a href="profilo_utente.jsp" class="list-group-item
        <% if (location.equals("profilo")) out.print("active"); %>">&nbsp&nbsp Profilo</a>
    <a href="#" class="list-group-item
       <% if (location.equals("inviti")) out.print("active"); %>">&nbsp&nbsp Inviti</a>
</div>
