<%@page import="borcellippa.coinquilini.casa.bacheca.bacheca.Bacheca"%>
<%@page import="borcellippa.coinquilini.casa.bacheca.post.Post"%>
<%@page import="java.util.List"%>
<%@page import="borcellippa.coinquilini.utente.Utente"%>
<%@include  file="../templates/topTemplateSideMenu.jsp" %>
<%
    Gson gsonCasa = new Gson();
    String casaFromJson = ((String) request.getAttribute("casa"));
    Casa casa = gsonCasa.fromJson(casaFromJson, Casa.class);
    Bacheca b = casa.getBacheca();
    System.out.println("### Bacheca in bacheca.jsp " + b.toString());
%>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h1>Scrivi il tuo primo post!</h1> 
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-3">
                        <div class="row">
                            <img src=""
                                 alt="immagine profilo"
                                 class="img-circle">
                        </div>
                        <div class="row">
                            Nome Cognome
                        </div>
                    </div>
                    <div class="col-md-9">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <form action="BachecaController" role="form" method="POST">
            <div class="row">
                <div class="col-md-12">
                    <textarea name="contenuto" class="form-control" rows="3" placeholder="Scrivi qui il tuo messaggio..."></textarea>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="col-md-10"></div>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-lg custom-button">Pubblica</button>
                    <input type="hidden" name="action" value="addPost">
                </div>
            </div>    
        </form>
    </div>

</div>

<%@include  file="../templates/botTemplateFree.jsp" %>