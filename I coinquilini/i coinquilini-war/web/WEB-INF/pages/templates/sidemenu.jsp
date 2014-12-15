<%@page import="borcellippa.coinquilini.utente.Utente"%>
<%@page import="com.google.gson.Gson"%>
<div class="list-group" id="sidemenu">
    <%
        Gson gsonLocation = new Gson();
        String location = "";
        if (request.getAttribute("location") != null) {
            String loc = request.getAttribute("location").toString();
            location = gsonLocation.fromJson(loc, String.class);
        }
    %>
    <a href="UserController?action=home" class="list-group-item">Home</a>
    <a href="#" class="list-group-item<% if (location.equals("bacheca")) out.print("active"); %>
       ">&nbsp&nbsp Bacheca</a>
    <a href="#" class="list-group-item<% if (location.equals("coinquilini")) out.print("active"); %>
       ">&nbsp&nbsp Coinquilini</a>
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