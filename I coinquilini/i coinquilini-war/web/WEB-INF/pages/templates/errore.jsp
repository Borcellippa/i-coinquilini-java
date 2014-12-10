<%@page import="borcellippa.coinquilini.users.utente.Utente"%>
<%@page import="com.google.gson.Gson"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>404 error page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <link href="css/global.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>
        <!-----start-wrap--------->
        <div class="wrap">
            <!-----start-content--------->
            <div class="content">
                <!-----start-logo--------->
                <div class="logo">

                </div>
                <!-----end-logo--------->
                <!-----start-search-bar-section--------->
                <div class="buttom">
                    <div class="seach_bar">
                        <p>you can go to <span><a href="index.jsp">home</a></span> page or search here</p>
                        <%  Gson gsonErrore = new Gson();
                            String erroreFromJson = (String)request.getAttribute("errorPage");
                            String errore = gsonErrore.fromJson(erroreFromJson, String.class);
                        %>
                        <h2><%= errore%></h2>
                        
                        <h1>Controlla che il Controller richiamato sia quello corretto, BABBEO!!!</h1>
                    </div>
                </div>
                <!-----end-sear-bar--------->
            </div>
        </div>

        <!---------end-wrap---------->
    </body>
</html>