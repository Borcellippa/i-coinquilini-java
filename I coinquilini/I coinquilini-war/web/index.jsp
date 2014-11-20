<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">

        <%@include  file="imports.html" %>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <%@include  file="header.html" %>
                <div class="col-md-2">
                    <%@include  file="sidemenu.html" %>
                </div>
                <div class="col-md-10">
                    <div class="col-md-3">
                        <div class="row">
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

                                        <input type="hidden" name="action" value="login">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

