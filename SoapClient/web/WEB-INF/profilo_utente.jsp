<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%  String nome = "", cognome = "", email = "", telefono = "", data_nascita = "", foto_path = "";
    Gson gsonUtente = new Gson();
    String utenteFromJson = (String) request.getAttribute("utente");
    String utente = gsonUtente.fromJson(utenteFromJson, String.class);
    JsonParser parser = new JsonParser();
    JsonObject jsonUtente = parser.parse(utente).getAsJsonObject();
    if (jsonUtente.get("nome") != null) {
        nome = jsonUtente.get("nome").getAsString();
    }
    if (jsonUtente.get("cognome") != null) {
        cognome = jsonUtente.get("cognome").getAsString();
    }
    if (jsonUtente.get("email") != null) {
        email = jsonUtente.get("email").getAsString();
    }
    if (jsonUtente.get("telefono") != null) {
        telefono = jsonUtente.get("telefono").getAsString();
    }
    if (jsonUtente.get("data_nascita") != null) {
        data_nascita = jsonUtente.get("data_nascita").getAsString();
    }
    if (jsonUtente.get("foto_path") != null) {
        foto_path = jsonUtente.get("foto_path").getAsString();
    }
%>

<html>
    <head>
        <title>SOAP Client</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    </head>
    <body>                                                             
        <div class="row">
            <div class="col-md-3">
                <img src="<%= foto_path%>" class="img-thumbnail" width="100%">
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-4">
                <div class="row">
                    <div class="form-group">
                        <label for="nome">Nome</label>
                        <input type="text" name="nome" class="form-control" required value='<%= nome%>' disabled>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="cognome">Cognome</label>
                        <input type="text" name="cognome" class="form-control" required value='<%= cognome%>' disabled>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" name="email" class="form-control" required readonly value='<%= email%>' disabled>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="text" name="telefono" class="form-control" pattern="[0-9]*" value='<%= telefono%>' disabled>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="data_nascita">Data di Nascita</label>
                        <input name="data_nascita" class="form-control" value='<%= data_nascita%>' disabled>
                    </div>
                </div>
            </div>
        </div>
        <br/>
    </body>
</html>

