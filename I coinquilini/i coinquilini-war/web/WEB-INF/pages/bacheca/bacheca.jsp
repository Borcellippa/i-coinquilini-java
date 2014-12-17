<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
        <form action="BachecaController" role="form" method="POST">
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-12">
                        <textarea style="resize:none;" name="contenuto" class="form-control" rows="3" placeholder="Scrivi qui il tuo messaggio..."></textarea>
                        <br/>
                    </div>
                </div>
            </div>
            <div class="col-md-2">
                <div class="col-md-12 commentButton">
                    <button type="submit" class="btn custom-button">Pubblica</button>
                    <input type="hidden" name="action" value="addPost">
                </div>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-md-12">
            <% if (listaPost.isEmpty()) { %>
            <h1>Scrivi il tuo primo post!</h1> 
            <% } else {
                for (int i = listaPost.size(); i > 0; i--) {
                    Post p = listaPost.get(i - 1);
                    String dataPost;
                    SimpleDateFormat df = new SimpleDateFormat();
                    df.applyPattern("dd/MM/yyyy HH:mm");
                    String[] splited;
            %>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-1 postAuthor">
                        <div class="row">
                            <img class="img-circle userCommentImage" src="<%= p.getAutore_img()%>" alt="immagine profilo">
                        </div>
                    </div>
                    <div class="col-md-3 postAuthor">
                        <div class="col-md-12">
                            <h3><%= p.getAutore()%></h3>
                            <p>
                                <% 
                                    dataPost = df.format(p.getDataPubblicazione());
                                    splited = dataPost.split(" ");
                                    out.println(splited[0]+" - "+splited[1]);
                                %>
                            </p>
                        </div>
                    </div>
                    <div class="col-md-6 postContent">
                        <%= p.getContenuto()%>
                    </div>
                    <div class="col-md-2 postOpt">
                        <% if (p.getAutore_email().equals(session.getAttribute("email"))) { %>
                        <form action="BachecaController" role="form" method="POST">
                            <button type="submit" class="btn btn-danger btn-sm">Elimina</button>
                            <input type="hidden" name="action" value="eliminaPost">
                            <input type="hidden" name="idPost" value="<%= p.getId() %>">
                        </form>
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
</div>

<%@include  file="../templates/botTemplateFree.jsp" %>