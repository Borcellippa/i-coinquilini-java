<%@page import="borcellippa.coinquilini.casa.bacheca.post.Post"%>
<%@page import="java.util.List"%>
<%@page import="borcellippa.coinquilini.users.utente.Utente"%>
<%@include  file="../templates/topTemplateSideMenu.jsp" %>
<%
    Gson gsonPosts = new Gson();
    String postsFromJson = ((String) request.getAttribute("listaPosts"));
    List<Post> listaPost = gsonPosts.fromJson(postsFromJson, List.class);
%>

<div class="row">
    <% if (listaPost == null) { %>
    <h1>Scrivi il tuo primo post!</h1> 
    <% } else {%>

    <div class="panel panel-default">
        <div class="panel-body">
            <div class="col-md-3">
                <div class="row">
                    <img src="<%=%>"
                         alt="immagine profilo"
                         class="img-circle">
                </div>
                <div class="row">
                    Nome Cognome
                </div>
            </div>
            <div class="col-md-9">
                contenuto contenuto contenuto contenuto contenuto contenuto contenuto contenuto contenuto contenuto contenuto contenuto contenuto contenuto contenuto 
            </div>
        </div>
    </div>




    <%= listaPost.toString()%>
    <% }%>


</div>

<%@include  file="../templates/botTemplateFree.jsp" %>