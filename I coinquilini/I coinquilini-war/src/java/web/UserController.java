/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.google.gson.Gson;
import ejb.coinquilini.users.GestoreUtenteLocal;
import ejb.coinquilini.users.Utente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bortignon Gianluca
 */
public class UserController extends HttpServlet {

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

        if (action.equals("addUtente")) {
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String telefono = request.getParameter("telefono");
            String nazionalita = request.getParameter("nazionalita");
            String data_nascita = request.getParameter("data_nascita");
            String citta_natale = request.getParameter("citta_natale");

            //Controllo che la mail non sia già presente nel DB
            Utente user = gestoreUtente.getUtenteByEmail(email);
            if (user == null) {
                gestoreUtente.addUtente(nome, cognome, email, password, telefono, nazionalita, data_nascita, citta_natale);
                user = gestoreUtente.getUtenteByEmail(email);
                String gsonUser = buildGson(user);
                request.setAttribute("utente", gsonUser);
                request.setAttribute("location", buildGson("profilo"));

                // session
                session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("nome", nome);
                session.setAttribute("tipoAccount", "utente");

                rd = getServletContext().getRequestDispatcher("/profilo_utente.jsp");
            }
            else {
                request.setAttribute("utente", buildGson(user));
                request.setAttribute("errore", buildGson("User già registrato"));
                request.setAttribute("location", buildGson("errore"));

                rd = getServletContext().getRequestDispatcher("/errore.jsp");
            }
        }
        if (action.equals("login")) {
            String email = request.getParameter("email");
            Utente user = gestoreUtente.getUtenteByEmail(email);

            // controllo password
            if (user != null) {
                String gsonUser = buildGson(user);
                request.setAttribute("utente", gsonUser);
                request.setAttribute("location", buildGson("profilo"));

                // session
                session = request.getSession();
                session.setAttribute("email", user.getEmail());
                session.setAttribute("nome", user.getNome());
                session.setAttribute("tipoAccount", "utente");
                
                if(user.getCasa() != null) {
                    session.setAttribute("tipoAccount", "utente");
                    session.setAttribute("casa", user.getCasa().getId());
                }
                
                rd = getServletContext().getRequestDispatcher("/profilo_utente.jsp");
            } else {
                request.setAttribute("location", buildGson("errore"));
                request.setAttribute("errore", buildGson("Login non riuscito"));
                rd = getServletContext().getRequestDispatcher("/errore.jsp");
            }
        }
        if (action.equals("logout")) {
            session = request.getSession();
            session.invalidate();
            rd = getServletContext().getRequestDispatcher("/index.jsp");
        }
        if (action.equals("home")) {
            rd = getServletContext().getRequestDispatcher("/index.jsp");
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

}
