/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import borcellippa.coinquilini.casa.casa.Casa;
import borcellippa.coinquilini.casa.casa.GestoreCasaLocal;
import borcellippa.coinquilini.utente.GestoreUtenteLocal;
import borcellippa.coinquilini.utente.Utente;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utility.Utility.*;

public class AnnunciController extends HttpServlet {

    @EJB
    private GestoreUtenteLocal gestoreUtente;
    @EJB
    private GestoreCasaLocal gestoreCasa;
    
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

        if (session.getAttribute("email") == null) {
            request.setAttribute("location", buildGson("home"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");
            rd.forward(request, response);
        }

        if (action.equals("visualizza_annunci")) {
            // TODO
        }
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
