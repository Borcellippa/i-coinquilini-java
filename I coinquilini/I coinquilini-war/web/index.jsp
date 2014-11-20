<%-- 
    Document   : index
    Created on : 20-nov-2014, 14.36.51
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        
        <%@include  file="header.html" %>
    </head>
    <body>
        <div>
            <form action="UserController" method="POST" role="form">
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="text" name="email" id="email">

                    <label for="password">Password</label>
                    <input type="password" name="password" id="password">

                    <button type="submit" class="btn btn-default">Submit</button>

                    <input type="hidden" name="action" value="login">
                </div>
            </form>
        </div>
        <div>
            <form action="registrazione.jsp" method="GET">
                <button type="submit" class="btn btn-default">Registrati</button>
            </form>
        </div>
    </body>
</html>

