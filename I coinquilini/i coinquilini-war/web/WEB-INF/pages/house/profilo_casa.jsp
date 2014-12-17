<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.lang.reflect.Type"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@include  file="../templates/topTemplateSideMenu.jsp" %>

<%  Gson gson = new Gson();
    String casaFromJson = ((String) request.getAttribute("casa"));
    Casa c = gson.fromJson(casaFromJson, Casa.class);

    String coinquiliniFromJson = ((String) request.getAttribute("coinquilini"));
    Type type = new TypeToken<ArrayList<Utente>>() {
    }.getType();
    ArrayList<Utente> uList = gson.fromJson(coinquiliniFromJson, type);

    String email = (String) session.getAttribute("email");
%>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-4">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
        <form method="POST" action="CasaController" role="form">

            <div class="row">
                <div class="form-group">
                    <label for="nome">Nome della Casa</label>
                    <input type="text" name="nome" class="form-control" required value='<%if (c.getNomeCasa() != null) {
                            out.println(c.getNomeCasa());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="codiceCasa">Codice Casa</label>
                    <input type="text" name="codiceCasa" class="form-control" required disabled value='<%if (c.getCodiceCasa() != null) {
                            out.println(c.getCodiceCasa());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="indirizzo">Indirizzo</label>
                    <input type="text" name="indirizzo" class="form-control" required value='<%if (c.getIndirizzo() != null) {
                            out.println(c.getIndirizzo());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="civico">Num. Civico</label>
                    <input type="text" name="civico" class="form-control" required value='<%if (c.getNcivico() != null) {
                            out.println(c.getNcivico());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="citta">Citt�</label>
                    <input type="text" name="citta" class="form-control" required value='<%if (c.getCitta() != null) {
                            out.println(c.getCitta());
                        }%>'>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="postiTotali">Posti disponibili</label>
                    <p><%=c.getPostiOccupati()%> / <%=c.getPostiTotali()%>
                </div>
            </div>

            <div class="row">
                <div class="form-group">
                    <button type="submit" class="btn btn-lg custom-button">Salva modifiche</button>
                </div>
                <input type="hidden" name="action" value="editCasa">
            </div>
        </form>
    </div>
    <div class="col-md-1"></div>     
    <div class="col-md-6">
        <h2>I tuoi coinquilini</h2>
        <div class="col-md-12" id="scroolUtenti">
            <ul class="list-group">
                <%  for (Utente u : uList) {
                        if (email != null && !u.getEmail().equals(email)) {
                %>
                <li class="list-group-item" style=" display: flex;">
                    <div class="col-md-4"> 
                        <img src="<%=u.getFoto_path()%>" class="img-thumbnail" width="70%" style="display: flex; align-items: center;">
                    </div>

                    <div class="col-md-8">

                        <ul class="uk-list uk-list-space">
                            <%  if (u.getNome() != null && u.getCognome() != null) {%>
                            <li>
                                <%=u.getNome()%> <%=u.getCognome()%>
                            </li> 
                            <% } %>
                            <%  if (u.getTelefono() != null) {%>
                            <li>
                                <%=u.getTelefono()%>
                            </li> 
                            <% } %>
                            <%   if (u.getCitta_natale() != null) {%>
                            <li>
                                <%=u.getCitta_natale()%>
                            </li> 
                            <% } %>
                            <%   if (u.getEmail() != null) {%>
                            <li>
                                <a href="mailto:<%=u.getEmail()%>" target="_top"><%=u.getEmail()%></a>
                            </li> 
                            <% }%>                 
                        </ul>
                    </div>
                </li>
                <%
                        }
                    }
                %>
            </ul>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form method="POST" action="CasaController" role="form">
            <div class="row">
                <div class="form-group">
                    <button type="submit" class="btn btn-danger">Abbandona casa</button>
                </div>
                <input type="hidden" name="action" value="abbandonaCasa">
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>


</div>
<%@include  file="../templates/botTemplateFree.jsp" %>