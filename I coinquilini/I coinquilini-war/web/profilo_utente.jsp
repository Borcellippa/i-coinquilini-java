<%-- 
    Document   : utente
    Created on : 19-nov-2014, 17.03.07
    Author     : Bortignon Gianluca
--%>
<%@page import="ejb.coinquilini.users.Utente"%>
<%@include  file="topTemplate1.jsp" %>
<%  Gson gsonUtente = new Gson();
    String utenteFromJson = (request.getAttribute("utente")).toString();
    Utente utente = gsonUtente.fromJson(utenteFromJson, Utente.class);
%>
    <h1><%= utente.getNome() %></h1>
<%@include  file="botTemplate1.jsp" %>