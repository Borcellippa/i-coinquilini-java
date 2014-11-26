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
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#loginModal">
                                Entra
                            </button>
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




        <div class="modal fade" id="loginModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Modal title</h4>
                    </div>
                    <div class="modal-body">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Login</h3>
                            </div>
                            <div class="panel-body">
                                <form action="UserController" method="POST" role="form">
                                    <div class="form-group">
                                        <label for="email">Email address</label>
                                        <input class="form-control" type="text" name="email" id="email" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input class="form-control" type="password" name="password" id="password" placeholder="Password">
                                    </div>

                                    <button type="submit" class="btn btn-primary">Login</button>
                                    oppure
                                    <a href="registrazione.jsp" class="btn btn-default" role="button">Registrati</a>

                                    <input type="hidden" name="action" value="login">
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>
</html>