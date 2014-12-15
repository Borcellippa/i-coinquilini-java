<%@page import="borcellippa.coinquilini.casa.casa.Casa"%>
<%@page import="borcellippa.coinquilini.casa.bacheca.post.Post"%>
<%@page import="java.util.List"%>
<%@page import="borcellippa.coinquilini.utente.Utente"%>
<%@include  file="../templates/topTemplateSideMenu.jsp" %>
<%
    Gson gsonCasa = new Gson();
    String casaFromJson = ((String) request.getAttribute("casa"));
    Casa c = gsonCasa.fromJson(casaFromJson, Casa.class);
    
    List<Post> listaPost = c.getBacheca().getPosts();
%>

<div class="row">
    <% if (listaPost == null) { %>
    <h1>Scrivi il tuo primo post!</h1> 
    <% } else { %>

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
                <%= listaPost.toString() %>
            </div>
        </div>
    </div>
    <% } %>

</div>

<%@include  file="../templates/botTemplateFree.jsp" %>