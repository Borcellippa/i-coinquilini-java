/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import borcellippa.coinquilini.casa.bacheca.bacheca.Bacheca;
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
import static utility.Utility.buildGson;

/**
 *
 * @author Mattia
 */
public class CasaController extends HttpServlet {

    @EJB
    private GestoreUtenteLocal gestoreUtente;
    @EJB
    private GestoreCasaLocal gestoreCasa;

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
        System.out.println("CasaController_action: " + action);

        HttpSession session = request.getSession();

        if (action == null) {
            request.setAttribute("location", buildGson("home"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");

        } else if (action.equals("creaCasa")) {
            request.setAttribute("location", buildGson("creaCasa"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/house/creaCasa.jsp");

        } else if (action.equals("addCasa")) {

            Utente u = gestoreUtente.getUtenteByEmail((String) session.getAttribute("email"));

            if (u.getTipoUtente().equals("U")) { // non ancora inquilino

                Casa c = new Casa();
                c.setIndirizzo(request.getParameter("indirizzo"));
                c.setNcivico(request.getParameter("civico"));
                c.setCitta(request.getParameter("citta"));
                c.setNomeCasa(request.getParameter("nome"));
                c.setPostiTotali(Integer.parseInt(request.getParameter("postiTotali")));
                c.addInquilino(u);
                c.setPostiOccupati(1); // chi crea la casa occupa un posto

                String codiceCasa = gestoreCasa.addCasa(c);

                c = gestoreCasa.getCasaByCodiceCasa(codiceCasa);

                // quando il coinquilino crea una casa ci si aggiunge automaticamente
                session = request.getSession();

                u.setTipoUtente("I");
                u.setCasa(c);
                gestoreUtente.editUtente(u);
                session.setAttribute("idCasa", c.getId());

                Bacheca b = c.getBacheca();
                String gsonBacheca = buildGson(b);
                request.setAttribute("bacheca", gsonBacheca);
                request.setAttribute("location", buildGson("bacheca"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/bacheca/bacheca.jsp");
            } else {
                request.setAttribute("errore", buildGson("casa_presente"));
                request.setAttribute("location", buildGson("home"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");

            }

        } else if (action.equals("entraInCasa")) {
            String codiceCasa = request.getParameter("codiceCasa");
            Casa c = gestoreCasa.getCasaByCodiceCasa(codiceCasa);
            Bacheca b = c.getBacheca();
            String gsonBacheca = buildGson(b);
            request.setAttribute("bacheca", gsonBacheca);
            request.setAttribute("location", buildGson("bacheca"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/bacheca/bacheca.jsp");
        } else { // caso in cui non ci sia nessuna action da eseguire
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
