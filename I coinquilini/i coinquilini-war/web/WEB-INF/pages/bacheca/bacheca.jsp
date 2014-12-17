<%@page import="borcellippa.coinquilini.casa.bacheca.bacheca.Bacheca"%>
<%@page import="borcellippa.coinquilini.casa.bacheca.post.Post"%>
<%@page import="java.util.List"%>
<%@page import="borcellippa.coinquilini.utente.Utente"%>
<%@include  file="../templates/topTemplateSideMenu.jsp" %>
<%
    Gson gsonCasa = new Gson();
    String casaFromJson = ((String) request.getAttribute("casa"));
    Casa casa = gsonCasa.fromJson(casaFromJson, Casa.class);
    List<Post> listaPost = casa.getBacheca().getPosts();
%>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <% if (listaPost.isEmpty()) { %>
            <h1>Scrivi il tuo primo post!</h1> 
            <% } else {
                for (int i = 0; i < listaPost.size(); i++) {
                    Post p = listaPost.get(i);
            %>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-1 postAuthor">
                        <div class="row">
                            <img style="width:50px;" src="<%= p.getAutore_img()%>" alt="immagine profilo" class="img-circle">
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <%= p.getAutore()%>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9 postContent">
                        <%= p.getContenuto()%>
                    </div>
                    <div class="col-md-2 postOpt">
                        <% if (p.getAutore_email().equals(session.getAttribute("email"))) { %>
                        <button type="button" class="btn btn-danger btn-sm">Elimina</button>
                        <% } %>
                    </div>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
    <div class="row">
        <form action="BachecaController" role="form" method="POST">
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10 commentBlock">
                    <div class="row">
                        <div class="col-md-12">
                            <textarea style="resize:none;" name="contenuto" class="form-control" rows="3" placeholder="Scrivi qui il tuo messaggio..."></textarea>
                            <br/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 commentButton">
                            <button type="submit" class="btn btn-lg custom-button">Pubblica</button>
                            <input type="hidden" name="action" value="addPost">
                        </div>
                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </form>
    </div>

</div>

<%@include  file="../templates/botTemplateFree.jsp" %>