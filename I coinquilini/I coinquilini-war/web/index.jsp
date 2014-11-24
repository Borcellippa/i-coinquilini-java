<%@include  file="topTemplate1.jsp" %>
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
                    oppure
                    <a href="registrazione.jsp" class="btn btn-default" role="button">Registrati</a>

                    <input type="hidden" name="action" value="login">
                </form>
            </div>
        </div>
    </div>
</div>
<%@include  file="botTemplate1.jsp" %>