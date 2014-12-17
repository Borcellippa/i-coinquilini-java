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
                    <div class="col-md-1" style="text-align:center;">
                        <div class="row">
                            <% String imageUrl = (String) session.getAttribute("url");%>
                            <img style="width:50px;" src="<%= imageUrl%>" alt="immagine profilo" class="img-thumbnail">
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <%= p.getAutore()%>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-11">
                        <%= p.getContenuto()%>
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
                <div class="col-md-10" style="margin-top:3%;">
                    <textarea style="resize:none;" name="contenuto" class="form-control" rows="3" placeholder="Scrivi qui il tuo messaggio..."></textarea>
                    <br/>
                    <button type="submit" class="btn btn-lg custom-button">Pubblica</button>
                    <input type="hidden" name="action" value="addPost">
                </div>
                <div class="col-md-1"></div>
            </div>
        </form>
    </div>

</div>

<%@include  file="../templates/botTemplateFree.jsp" %>