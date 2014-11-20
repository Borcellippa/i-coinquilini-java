<%-- 
    Document   : registrazione
    Created on : 20-nov-2014, 15.10.18
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include  file="header.html" %>
    </head>
    <body>
        <h1>Registrazione</h1>
        <form method="POST" action="UserController" role="form">
            <div style="width:50%">
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" class="form-control">
                </div>
                <div class="form-group">
                    <label for="cognome">Cognome</label>
                    <input type="text" name="cognome" class="form-control">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" name="email" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control">
                </div>
                <div class="form-group">
                    <label for="tel">Telefono</label>
                    <input type="text" name="telefono" class="form-control" pattern="[0-9]*">
                </div>
                <div class="form-group">
                    <label for="nazionalita">Nazionalità</label>
                    <input type="text" name="nazionalita" class="form-control">
                </div>
                <div class="form-group">
                    <label for="data_nascita">Data di Nascita</label>
                    <input type="date" name="data_nascita" class="form-control">
                </div>
                <div class="form-group">
                    <label for="citta_natale">Città natale</label>
                    <input type="text" name="citta_natale" class="form-control">
                </div>
                <div class="form-group">
                   <button type="submit" class="btn btn-default">Submit</button>
                </div>
                
                <input type="hidden" name="action" value="addUtente">
            </div>
        </form>
    </body>
</html>
