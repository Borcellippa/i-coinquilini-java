<%@page import="ejb.coinquilini.users.Utente"%>
<%@page import="com.google.gson.Gson"%>
<div class="list-group">
    <%Gson gsonLocation = new Gson();
    String locationFromJson = (request.getAttribute("location")).toString();
    String location = gsonLocation.fromJson(locationFromJson, String.class);%>
    <a href="#" class="list-group-item">Home</a>
    <a href="#" class="list-group-item">&nbsp&nbsp Dashboard</a>
    <a href="#" class="list-group-item">&nbsp&nbsp Coinquilini</a>
    <a href="#" class="list-group-item">Eventi</a>
    <a href="#" class="list-group-item">&nbsp&nbsp Calendario</a>
    <a href="#" class="list-group-item">&nbsp&nbsp Promemoria</a>
    <a href="#" class="list-group-item">&nbsp&nbsp Mansioni</a>
    <a href="#" class="list-group-item">Borsellino</a>
    <a href="#" class="list-group-item">&nbsp&nbsp Wishlist</a>
    <a href="#" class="list-group-item">&nbsp&nbsp Le mie spese</a>
    <a href="#" class="list-group-item">&nbsp&nbsp Debiti</a>
    <a href="#" class="list-group-item">Opzioni</a>
    <a href="profilo_utente.jsp" class="list-group-item
    <% if (location.equals("profilo_utente")) out.print("active"); %>">&nbsp&nbsp Profilo</a>
    <a href="#" class="list-group-item">&nbsp&nbsp Inviti</a>
</div>