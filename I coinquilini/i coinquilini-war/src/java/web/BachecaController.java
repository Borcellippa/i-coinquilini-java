/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import borcellippa.coinquilini.casa.bacheca.bacheca.GestoreBachecaLocal;
import borcellippa.coinquilini.casa.casa.Casa;
import borcellippa.coinquilini.casa.casa.GestoreCasaLocal;
import borcellippa.coinquilini.utente.GestoreUtenteLocal;
import borcellippa.coinquilini.utente.Utente;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utility.Utility.*;

/**
 *
 * @author Fede
 */
@WebServlet(name = "BachecaController", urlPatterns = {"/BachecaController"})
public class BachecaController extends HttpServlet {

    @EJB
    private GestoreBachecaLocal gestoreBacheca;
    @EJB
    private GestoreCasaLocal gestoreCasa;
    @EJB
    private GestoreUtenteLocal gestoreUtente;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        RequestDispatcher rd;
        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        request = initializeRequest(request, (String) session.getAttribute("email"), (String) session.getAttribute("idCasa"));

        if (action == null) {
            request.setAttribute("location", buildGson("home"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");

        } else if (action.equals("addPost")) {
            String idCasa = (String) session.getAttribute("idCasa");
            Casa c = gestoreCasa.getCasaById(idCasa);
            // notifico il post nuovo ai coinquilini
            List<Long> usersList = c.getUtenti();
            for (Long i : usersList) {
                Utente coinquilino = gestoreUtente.getUtenteById(i);
                if (!coinquilino.getEmail().equals(session.getAttribute("email"))) {
                    gestoreUtente.notifyUser("post", coinquilino.getId());
                }
            }
            // aggiungo il post alla bacheca
            gestoreBacheca.addPost(
                    (String) session.getAttribute("email"),
                    request.getParameter("contenuto"),
                    idCasa);
            Utente u = gestoreUtente.getUtenteByEmail((String) session.getAttribute("email"));
            gestoreUtente.resetNotifications("post", u.getId());
            c = gestoreCasa.getCasaById(idCasa);
            initializeRequest(request, (String) session.getAttribute("email"), idCasa);
            request.setAttribute("location", buildGson("bacheca"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/bacheca/bacheca.jsp");

        } else if (action.equals("getBacheca")) {
            //Recupero i dati della wishlist da DB
            String idCasa = (String) session.getAttribute("idCasa");
            Utente u = gestoreUtente.getUtenteByEmail((String) session.getAttribute("email"));
            gestoreUtente.resetNotifications("post", u.getId());
            // necessario per l'aggiornamento dell'oggetto utente e relative notifiche
            initializeRequest(request, (String) session.getAttribute("email"), idCasa);
            request.setAttribute("location", buildGson("bacheca"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/bacheca/bacheca.jsp");

        } else if (action.equals("eliminaPost")) {
            String idCasa = (String) session.getAttribute("idCasa");
            Casa c = gestoreCasa.getCasaById(idCasa);
            String idPost = request.getParameter("idPost");
            gestoreBacheca.eliminaPost(c.getBacheca(), Long.parseLong(idPost));
            Utente u = gestoreUtente.getUtenteByEmail((String) session.getAttribute("email"));
            gestoreUtente.resetNotifications("post", u.getId());
            initializeRequest(request, (String) session.getAttribute("email"), idCasa);
            request.setAttribute("location", buildGson("bacheca"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/bacheca/bacheca.jsp");

        } else {
            request.setAttribute("location", buildGson("error_page"));
            request.setAttribute("errorPage", buildGson("no_action"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/templates/errore.jsp");
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
    }// </editor-fold

    public HttpServletRequest initializeRequest(HttpServletRequest request, String email, String idCasa) {
        if (email != null) {
            Utente u = gestoreUtente.getUtenteByEmail(email);
            request.setAttribute("utente", buildGson(u));
        }
        if (idCasa != null) {
            Casa c = gestoreCasa.getCasaById(idCasa);
            request.setAttribute("casa", buildGson(c));
        }
        return request;
    }
}
