<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="borcellippa.coinquilini.casa.casa.Casa"%>
<%@page import="borcellippa.coinquilini.utente.Utente"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="com.google.gson.JsonObject"%>



<%
    String iconUrl = "",descrizioneMeteo = "", mainMeteo = "";
    int temperatura = 0;
    Gson gsonLocation = new Gson();
    String location = "";
    if (request.getAttribute("location") != null) {
        String loc = (String)request.getAttribute("location");
        location = gsonLocation.fromJson(loc, String.class);
    }
    
    Utente u = new Utente();
    if (request.getAttribute("utente") != null) {
        String ut = (String)request.getAttribute("utente");
        u = gsonLocation.fromJson(ut, Utente.class);
        Casa c = u.getCasa();
        
        try{
            /* Scarico il json */
            String meteoUrl = "http://molten-ruler-747.appspot.com";
            URL obj = new URL(meteoUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            String urlParameters = "citta="+c.getCitta();
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer res = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                    res.append(inputLine);
            }
            in.close();
            
            /* Lo parsifico */
            String meteoString = new String(res);
            JsonParser parser = new JsonParser();
            JsonObject jsonMeteo = parser.parse(meteoString).getAsJsonObject();
            String cod = jsonMeteo.get("cod").getAsString();
            if(cod.equals("200")){
                System.out.println("OOOK");
                JsonArray array = jsonMeteo.getAsJsonArray("weather");
                String tempString = array.get(0).toString();
                JsonObject tempObj = parser.parse(tempString).getAsJsonObject();

                //immagine
                iconUrl = "http://openweathermap.org/img/w/"+tempObj.get("icon").getAsString()+".png";

                // testo
                descrizioneMeteo = tempObj.get("description").getAsString();
                
                // main
                mainMeteo = tempObj.get("main").getAsString();
                
                // temp
                JsonObject temperaturaTemp = jsonMeteo.getAsJsonObject("main");
                temperatura = (int)temperaturaTemp.get("temp").getAsFloat();
                System.out.println("STAMPO: "+iconUrl);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
%>


<div class="container" id="sidemenu">
    <div class="col-sm-3 col-md-3">
        <div class="panel-group" id="accordion">
            <div class="panel panel-default">
                <div class="panel-heading sidebar-panel">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                        <h4 class="panel-title">
                            <span class="glyphicon glyphicon-home">
                            </span>La mia casa
                        </h4>
                    </a>
                </div>
                <div id="collapseOne" class="panel-collapse collapse
                     <% if (location.equals("bacheca") || location.equals("profilo_casa") || location.equals("wishlist")) {
                             out.print("in");
                         }%>">
                    <div class="panel-body">
                        <table class="table">
                            <tr class="<% if (location.equals("bacheca")) {
                                        out.print("active");
                                    } %>">
                                <td class="sidebar-td">
                                    <span class="glyphicon glyphicon-comment text-success"></span><a href="BachecaController?action=getBacheca">Bacheca</a>
                                    <span class="badge">
                                        <%= u.getPostUnread() %>
                                    </span>
                                </td>
                            </tr>
                            <tr class="<% if (location.equals("profilo_casa")) {
                                        out.print("active");
                                    } %>">
                                <td>
                                    <span class="glyphicon glyphicon-pencil"></span><a href="CasaController?action=profilo_casa">Profilo casa</a>
                                </td>
                            </tr>
                            <tr class="<% if (location.equals("wishlist")) {
                                        out.print("active");
                                    } %>">
                                <td>
                                    <span class="glyphicon glyphicon-list-alt text-primary"></span><a href="WishlistController?action=getWishlist">Lista della spesa</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading sidebar-panel">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                        <h4 class="panel-title">
                            <span class="glyphicon glyphicon-bookmark">
                            </span>I miei impegni
                        </h4>
                    </a>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse
                     <% if (location.equals("calendario") || location.equals("promemoria") || location.equals("mansioni")) {
                             out.print("in");
                         }%>">
                    <div class="panel-body">
                        <table class="table">
                            <tr class="<% if (location.equals("calendario")) {
                                        out.print("active");
                                    } %>">
                                <td>
                                    <span class="glyphicon glyphicon-calendar text-success"></span><a href="#Calendatio">Calendario</a>
                                </td>
                            </tr>
                            <tr class="<% if (location.equals("promemoria")) {
                                        out.print("active");
                                    } %>">
                                <td>
                                    <span class="glyphicon glyphicon-pushpin text-alert"></span><a href="#Promemoria">Promemoria</a>
                                </td>
                            </tr>
                            <tr class="<% if (location.equals("mansioni")) {
                                        out.print("active");
                                    } %>">
                                <td>
                                    <span class="glyphicon glyphicon-wrench text-danger"></span><a href="#Mansioni">Mansioni</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading sidebar-panel">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                        <h4 class="panel-title">
                            <span class="glyphicon glyphicon-euro">
                            </span>Le mie spese
                        </h4>
                    </a>
                </div>
                <div id="collapseThree" class="panel-collapse collapse
                     <% if (location.equals("debiti") || location.equals("borsellino")) {
                             out.print("in");
                         }%>">
                    <div class="panel-body">
                        <table class="table">
                            <tr class="<% if (location.equals("debiti")) {
                                        out.print("active");
                                    } %>">
                                <td>
                                    <span class="glyphicon glyphicon-send text-alert"></span><a href="#Debiti">Debiti</a>
                                </td>
                            </tr>
                            <tr class="<% if (location.equals("borsellino")) {
                                        out.print("active");
                                    } %>">
                                <td>
                                    <span class="glyphicon glyphicon-print text-success"></span><a href="#Borsellino">Borsellino</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading sidebar-panel">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                        <h4 class="panel-title">
                            <span class="glyphicon glyphicon-user">
                            </span>Account
                        </h4>
                    </a>
                </div>
                <div id="collapseFour" class="panel-collapse collapse
                     <% if (location.equals("profilo_utente")) {
                             out.print("in");
                         }%>">
                    <div class="panel-body">
                        <table class="table">
                            <tr class="<% if (location.equals("profilo_utente")) {
                                        out.print("active");
                                    }%>">
                                <td>
                                    <span class="glyphicon glyphicon-cog"></span><a href="UserController?action=profilo_utente">Il mio profilo</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        
        </br>
        
        <% if(u != null && u.getCasa() != null){ %>
        <div id="meteo">
            <fieldset id="meteoContainer">
                <h2>Meteo a <b><%= u.getCasa().getCitta() %></b></h2>
                <div style="display: flex; margin-top: -25px; margin-left: -26px;">
                    <img src="<%= iconUrl %>" style="width: 80px; height: 80px">
                    <h1 style="margin-top: 20px"><b><%= temperatura %>°</b></h1>
                </div>
                <div>
                    <h4>Si prevede <b><%= descrizioneMeteo %></b></h4>
                </div>
            </fieldset>
        </div>
        <% } %>
    </div>
</div>