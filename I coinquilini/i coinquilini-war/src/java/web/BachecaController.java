/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import borcellippa.coinquilini.casa.bacheca.bacheca.Bacheca;
import borcellippa.coinquilini.casa.bacheca.bacheca.GestoreBachecaLocal;
import borcellippa.coinquilini.casa.bacheca.post.Post;
import borcellippa.coinquilini.casa.casa.Casa;
import borcellippa.coinquilini.casa.casa.CasaFacadeLocal;
import borcellippa.coinquilini.casa.casa.GestoreCasaLocal;
import borcellippa.coinquilini.utente.GestoreUtenteLocal;
import borcellippa.coinquilini.utente.Utente;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utility.Utility.buildGson;

/**
 *
 * @author Fede
 */
@WebServlet(name = "BachecaController", urlPatterns = {"/BachecaController"})
public class BachecaController extends HttpServlet {

    @EJB
    private GestoreBachecaLocal gestoreBacheca;
    @EJB
    private CasaFacadeLocal casaFacade;
    @EJB
    private GestoreCasaLocal gestoreCasa;
    @EJB
    private GestoreUtenteLocal gestoreUtente;

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

        RequestDispatcher rd;
        String action = request.getParameter("action");
        System.out.println("BachecaController_action: " + action);

        HttpSession session = request.getSession();

        if (action == null) {
            request.setAttribute("location", buildGson("home"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");
        } else if (action.equals("addPost")) {
            session = request.getSession();
            String idCasa = (String) session.getAttribute("idCasa");
            Casa c = casaFacade.find(idCasa);
            Bacheca b = c.getBacheca();
            gestoreBacheca.addPost((String) session.getAttribute("email"), request.getParameter("contenuto"), b.getId(), (String) session.getAttribute("idCasa"));
            
            String gsonCasa = buildGson(c);
            request.setAttribute("casa", gsonCasa);
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
    }// </editor-fold>

}
