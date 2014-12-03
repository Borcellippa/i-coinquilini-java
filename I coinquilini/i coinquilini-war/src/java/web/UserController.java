package web;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ejb.coinquilini.users.GestoreUserCookieLocal;
import ejb.coinquilini.users.GestoreUtenteLocal;
import ejb.coinquilini.users.Utente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserController extends HttpServlet {

    @EJB
    private GestoreUserCookieLocal gestoreUserCookie;

    @EJB
    GestoreUtenteLocal gestoreUtente;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // creo la sessione utente o richiamo quella già creata
        HttpSession session = request.getSession();

        if (session.getAttribute("email") == null) {
            session.setAttribute("email", "ospite");
            session.setAttribute("tipoAccount", "ospite");
            session.setAttribute("nome_utente", "ospite");
        }

        RequestDispatcher rd = null;
        String action = request.getParameter("action");

        if (action == null) {
            rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }

        if (action.equals("addUtente")) {
            String email = request.getParameter("email");
            String nome = request.getParameter("nome");
            //Controllo che la mail non sia già presente nel DB
            Utente user = gestoreUtente.getUtenteByEmail(email);

            if (user == null) {
                Utente u = new Utente();
                u.setNome(request.getParameter("nome"));
                u.setCognome(request.getParameter("cognome"));
                u.setEmail(request.getParameter("email"));
                u.setPassword(request.getParameter("password"));
                u.setTelefono(request.getParameter("telefono"));
                u.setNazionalita(request.getParameter("nazionalita"));
                u.setData_nascita(request.getParameter("data_nascita"));
                u.setCitta_natale(request.getParameter("citta_natale"));

                gestoreUtente.addUtente(u);
                user = gestoreUtente.getUtenteByEmail(email);
                String gsonUser = buildGson(user);
                request.setAttribute("utente", gsonUser);
                request.setAttribute("location", buildGson("profilo"));

                // session
                response = this.initializeLogin(request, response, nome, email, -1);

                rd = getServletContext().getRequestDispatcher("/profilo_utente.jsp");
            } else {
                request.setAttribute("utente", buildGson(user));
                request.setAttribute("errore", buildGson("User già registrato"));
                request.setAttribute("location", buildGson("errore"));

                rd = getServletContext().getRequestDispatcher("/errore.jsp");
            }
        }

        if (action.equals("profilo_utente")) {
            session = request.getSession();
            String email = (String) session.getAttribute("email");
            Utente user = gestoreUtente.getUtenteByEmail(email);
            String gsonUser = buildGson(user);
            request.setAttribute("utente", gsonUser);
            request.setAttribute("location", buildGson("profilo"));
            rd = getServletContext().getRequestDispatcher("/profilo_utente.jsp");
        }

        if (action.equals("login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Utente user = gestoreUtente.verificaLogin(email, password);

            if (user != null) {
                String gsonUser = buildGson(user);
                request.setAttribute("utente", gsonUser);
                request.setAttribute("location", buildGson("profilo"));

                // session
                if (user.getCasa() != null) {
                    response = this.initializeLogin(request, response, user.getNome(), email, user.getCasa().getId());
                } else {
                    response = this.initializeLogin(request, response, user.getNome(), email, -1);
                }

                rd = getServletContext().getRequestDispatcher("/profilo_utente.jsp");
                // se la password è sbagliata e l'utente non esiste
            } else {
                request.setAttribute("location", buildGson("home"));
                request.setAttribute("errore", buildGson("errore_login"));
                rd = getServletContext().getRequestDispatcher("/home.jsp");
            }
        }

        if (action.equals("logout")) {
            session = request.getSession();
            session.invalidate();
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("login")) {
                    cookies[i].setMaxAge(0);
                    cookies[i].setValue("nd");
                    response.addCookie(cookies[i]);
                    break;
                }
            }
            rd = getServletContext().getRequestDispatcher("/index.jsp");
        }

        if (action.equals("firstRedirect")) {
            Cookie[] cookies = request.getCookies();
            boolean foundCookie = false;
            Cookie userCookie = null;
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("login")) {
                    foundCookie = true;
                    userCookie = cookies[i];
                    break;
                }
            }

            if (!foundCookie || (userCookie != null && userCookie.getValue().equals("nd"))) {
                rd = getServletContext().getRequestDispatcher("/home.jsp");
            } else {
                Utente u = gestoreUserCookie.getUtenteByToken(userCookie.getValue());
                if (u != null) {
                    long casaId;
                    if (u.getCasa() != null) {
                        casaId = u.getCasa().getId();
                    } else {
                        casaId = -1;
                    }
                    response = this.initializeLogin(request, response, u.getNome(), u.getEmail(), casaId);
                    String gsonUser = buildGson(u);
                    request.setAttribute("utente", gsonUser);
                    request.setAttribute("location", buildGson("profilo"));
                    rd = getServletContext().getRequestDispatcher("/profilo_utente.jsp");
                } else {
                    /* Se il cookie è presente ma sbagliato lo si cancella */
                    userCookie.setMaxAge(0);
                    userCookie.setValue("nd");
                    response.addCookie(userCookie);
                    rd = getServletContext().getRequestDispatcher("/home.jsp");
                }
            }
        }
        if (action.equals("registrazione")) {
            request.setAttribute("location", buildGson("registrazione"));
            rd = getServletContext().getRequestDispatcher("/registrazione.jsp");
        }

        if (action.equals("loginFacebook")) {
            String userData = (String) request.getParameter("userData");
            JsonParser parser = new JsonParser();
            JsonObject jsonPerson = parser.parse(userData).getAsJsonObject();

            // info from facebook
            String email = jsonPerson.get("email").getAsString();
            String nome = jsonPerson.get("first_name").getAsString();
            String cognome = jsonPerson.get("last_name").getAsString();
            String genere = jsonPerson.get("gender").getAsString();
            String fb_id = jsonPerson.get("id").getAsString();
            String fb_token = jsonPerson.get("accessToken").getAsString();

            //Controllo che la mail non sia già presente nel DB
            Utente u = gestoreUtente.getUtenteByEmail(email);

            //Se l'utente non si è mai registrato lo invio alla pagina di richesta passoword
            boolean needPwd = false;
            if (u == null) {
                u = new Utente();
                u.setNome(nome);
                u.setCognome(cognome);
                u.setGenere(genere);
                u.setFb_access_token(fb_token);
                u.setFb_user_id(fb_id);
                u.setEmail(email);
                gestoreUtente.addUtente(u);
                needPwd = true;

            } // Altrimenti lo tiro solo su introducendo le informazioni di facebook
            else {
                u.setNome(nome);
                u.setCognome(cognome);
                u.setGenere(genere);
                u.setFb_access_token(fb_token);
                u.setFb_user_id(fb_id);
                gestoreUtente.editUtente(u);
            }

            u = gestoreUtente.getUtenteByEmail(email);
            String gsonUser = buildGson(u);
            request.setAttribute("utente", gsonUser);
            
            // se mi sono loggato con facebook devo ancora modificare il profilo per inserire una passoword
            if (needPwd) { 
                request.setAttribute("location", buildGson("completaSocial"));
                rd = getServletContext().getRequestDispatcher("/completaSocial.jsp");

            } else {
                request.setAttribute("location", buildGson("profilo"));
                rd = getServletContext().getRequestDispatcher("/profilo_utente.jsp");

            }
            // session
            response = this.initializeLogin(request, response, nome, email, -1);

        }

        if (action.equals("gLogin")) {

            String token = request.getParameter("param1");

            if (token != null) {
                String email = "";
                String nome = "";
                String s = "https://www.googleapis.com/plus/v1/people/me?access_token=" + token;
                InputStream is = new URL(s).openStream();
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                    StringBuilder sb = new StringBuilder();
                    int cp;
                    while ((cp = reader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    String jsonText = sb.toString();

                    JsonParser parser = new JsonParser();
                    JsonObject jsonPerson = parser.parse(jsonText).getAsJsonObject();

                    String genere = jsonPerson.get("gender").getAsString();

                    JsonArray emailsJsonArray = jsonPerson.getAsJsonArray("emails");
                    JsonElement emailJsonElement = emailsJsonArray.get(0);
                    JsonObject primaryEmailJsonObject = emailJsonElement.getAsJsonObject();
                    email = primaryEmailJsonObject.get("value").getAsString();

                    JsonObject nomeJson = jsonPerson.getAsJsonObject("name");
                    nome = nomeJson.get("givenName").getAsString();
                    String cognome = nomeJson.get("familyName").getAsString();

                    JsonObject imageJson = jsonPerson.getAsJsonObject("image");
                    String imageUrl = imageJson.get("url").getAsString();

                    JsonArray placesJsonArray = jsonPerson.getAsJsonArray("placesLived");
                    JsonElement placeJsonElement = placesJsonArray.get(0);
                    JsonObject primaryPlaceJsonObject = placeJsonElement.getAsJsonObject();
                    String location = primaryPlaceJsonObject.get("value").getAsString();

                    Utente user = gestoreUtente.getUtenteByEmail(email);
                    if (user == null) {
                        user = new Utente();
                        user.setNome(nome);
                        user.setCognome(cognome);
                        user.setGenere(genere);
                        user.setEmail(email);
                        user.setG_access_token(token);

                        //System.out.println(u.toString());
                        gestoreUtente.addUtente(user);
                        user = gestoreUtente.getUtenteByEmail(email);
                        String gsonUser = buildGson(user);
                        request.setAttribute("utente", gsonUser);
                        // Serve per accendere le entry della pagina di arrivo
                        request.setAttribute("location", buildGson("profilo"));

                        // set session
                        response = this.initializeLogin(request, response, nome, email, -1);
                    } else {
                        // TODO Integrazione dati g+ con quelli nel nostro DB da registrazione normale
                    }
                    // chiudi lo stream
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Se l'inserimento in db è andato a buon fine carico i dati da lì per usarli nella prossima view
                if (!email.equals("")) {
                    // creazione argomenti per la prossima pagina
                    Utente user = gestoreUtente.getUtenteByEmail(email);
                    String gsonUser = buildGson(user);
                    request.setAttribute("utente", gsonUser);
                    request.setAttribute("location", buildGson("profilo"));

                    // session
                    response = this.initializeLogin(request, response, nome, email, -1);

                    rd = getServletContext().getRequestDispatcher("/profilo_utente.jsp");
                }
            } else {
                rd = getServletContext().getRequestDispatcher("/errore.jsp");
            }
        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String buildGson(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);

        if (json == null) {
            System.out.println("servlet buildGson: NULL");
        } else {
            System.out.println("servlet buildGson: NOT NULL  " + json);
        }
        return json;
    }

    private HttpServletResponse initializeLogin(HttpServletRequest request, HttpServletResponse response, String nome, String email, long idCasa) {
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("nome", nome);
        session.setAttribute("tipoAccount", "utente");
        session.setAttribute("idCasa", idCasa);
        String token = gestoreUserCookie.createUserCookie(email);
        Cookie cookie1 = new Cookie("login", token);
        cookie1.setMaxAge(365 * 24 * 60 * 60);
        response.addCookie(cookie1);
        return response;
    }

}
