/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import borcellippa.coinquilini.casa.casa.Casa;
import borcellippa.coinquilini.casa.casa.GestoreCasaLocal;
import borcellippa.coinquilini.casa.wishlist.GestoreWishlistLocal;
import borcellippa.coinquilini.casa.wishlist.Wishlist;
import borcellippa.coinquilini.utente.GestoreUtenteLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utility.Utility.*;

/**
 *
 * @author Bortignon Gianluca
 */
public class WishlistController extends HttpServlet {

    @EJB
    private GestoreCasaLocal gestoreCasa;
    @EJB
    private GestoreWishlistLocal gestoreWishlist;
    @EJB
    private GestoreUtenteLocal gestoreUtente;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // creo la sessione utente o richiamo quella già creata
        HttpSession session = request.getSession();

        RequestDispatcher rd;
        String action = request.getParameter("action");

        if (action == null) {
            request.setAttribute("location", buildGson("home"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");
        } else if (action.equals("getWishlist")) {
            //Recupero i dati della wishlist da DB
            String idCasa = (String) session.getAttribute("idCasa");
            Casa c = gestoreCasa.getCasaById(idCasa);
            Wishlist w = c.getWishlist();

            if (w != null) {
                String gsonWishlist = buildGson(w);
                request.setAttribute("wishlist", gsonWishlist);
                request.setAttribute("casa", buildGson(c));
                request.setAttribute("location", buildGson("wishlist"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/house/wishlist.jsp");
            } else {
                request.setAttribute("errore", buildGson("Errore durante la creazione della wishlist"));
                request.setAttribute("location", buildGson("home"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");
            }
        } else if (action.equals("creaEntryWishlist")) {
            String idCasa = (String) session.getAttribute("idCasa");
            Casa c = gestoreCasa.getCasaById(idCasa);
            Wishlist w = c.getWishlist();
            if (w != null) {
                String descrizione = request.getParameter("descrizione");
                descrizione = Character.toUpperCase(descrizione.charAt(0)) + descrizione.substring(1);
                int quantita = Integer.parseInt(request.getParameter("quantita"));
                w = gestoreWishlist.addEntry(w, descrizione, quantita);
                String gsonWishlist = buildGson(w);
                request.setAttribute("wishlist", gsonWishlist);
                request.setAttribute("location", buildGson("wishlist"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/house/wishlist.jsp");
            } else {
                request.setAttribute("errore", buildGson("Errore durante la creazione della wishlist"));
                request.setAttribute("location", buildGson("home"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");
            }
        } else if (action.equals("deleteEntry")) {
            String idCasa = (String) session.getAttribute("idCasa");
            Casa c = gestoreCasa.getCasaById(idCasa);
            Wishlist w = c.getWishlist();
            if (w != null) {
                Long idEntry = Long.parseLong(request.getParameter("EID"));
                w = gestoreWishlist.deleteEntry(w, idEntry);
                String gsonWishlist = buildGson(w);
                request.setAttribute("wishlist", gsonWishlist);
                request.setAttribute("location", buildGson("wishlist"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/house/wishlist.jsp");
            } else {
                request.setAttribute("errore", buildGson("Errore durante la creazione della wishlist"));
                request.setAttribute("location", buildGson("home"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");
            }
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
