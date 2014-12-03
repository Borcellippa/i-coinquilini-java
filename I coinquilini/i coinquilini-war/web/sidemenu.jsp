<%@page import="ejb.coinquilini.users.Utente"%>
<%@page import="com.google.gson.Gson"%>
<div class="list-group">
    <%
        Gson gsonLocation = new Gson();
        String location = "";
        if (request.getAttribute("location") != null) {
            String loc = request.getAttribute("location").toString();
            location = gsonLocation.fromJson(loc, String.class);
        }
    %>
    <a href="home.jsp" class="list-group-item">Home</a>
    <a href="dashboard.jsp" class="list-group-item">&nbsp&nbsp Dashboard</a>
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
    <a href="#" class="list-group-item
       <% if (location.equals("wishlist")) out.print("active"); %>">&nbsp&nbsp Wishlist</a>
    <a href="#" class="list-group-item
       <% if (location.equals("le_mie_spese")) out.print("active"); %>">&nbsp&nbsp Le mie spese</a>
    <a href="#" class="list-group-item
       <% if (location.equals("debiti")) out.print("active"); %>">&nbsp&nbsp Debiti</a>
    <a href="#" class="list-group-item
       <% if (location.equals("opzioni")) out.print("active"); %>">Opzioni</a>
    <a href="#" class="list-group-item
        <% if (location.equals("profilo")) out.print("active"); %>">&nbsp&nbsp Profilo</a>
    <a href="#" class="list-group-item
       <% if (location.equals("inviti")) out.print("active"); %>">&nbsp&nbsp Inviti</a>
</div>