<%-- 
    Document   : home
    Created on : 25-nov-2014, 11.20.53
    Author     : Bortignon Gianluca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>I coinquilini</title>
        <%@include  file="imports.html" %>
    </head>
    <body>
        <div id="jumbotron" class="jumbotron">
            <div id="jumbotron-man" class="container">
                <h1 id="jumbotronLabel">Roommates</h1>
            </div>
        </div>
        <div class="uk-grid" id="home-container" style="bottom: 0;display: block;">
            <div class="uk-width-1-2" style="margin-right: 0px;padding-right: 1px">
                <div class="uk-overlay">
                    <img src="images/a.jpg" style="" alt="">
                    <div class="uk-overlay-area">
                        <div class="uk-overlay-area-content">
                                Entra in casa e inizia e rendere produttiva la tua convivenza
                                </br>
                                <button class="uk-button-primary uk-botton-large" type="button">Entra</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="uk-width-1-2">
                <div class="uk-overlay">
                    <img src="images/b.jpg" style="margin-left: 0px;padding-left: 1px" alt="">
                    <div class="uk-overlay-area">
                        <div class="uk-overlay-area-content">
                            Cerca facilmente una casa in base alle tue esigenze
                            </br>
                            <button class="uk-button-primary uk-botton-large" type="button">Entra</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
