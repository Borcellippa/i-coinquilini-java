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
    <% if(listaPost==null){ %>
    <h1>Scrivi il tuo primo post!</h1> 
    <% } else { %>
        <%= listaPost.toString() %>
    <% } %>

    
</div>

<%@include  file="../templates/botTemplateFree.jsp" %>