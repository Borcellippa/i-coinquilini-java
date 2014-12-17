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
import java.util.ArrayList;
import java.util.List;
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
                String nomeCasa = request.getParameter("nome");
                nomeCasa = Character.toUpperCase(nomeCasa.charAt(0)) + nomeCasa.substring(1);
                c.setNomeCasa(nomeCasa);
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
                
                gestoreUtente.resetNotifications("post", u.getId());
                String gsonCasa = buildGson(c);
                request.setAttribute("casa", gsonCasa);
                request.setAttribute("location", buildGson("bacheca"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/bacheca/bacheca.jsp");
            } else {
                request.setAttribute("errore", buildGson("casa_presente"));
                request.setAttribute("location", buildGson("home"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");

            }

        } else if (action.equals("editCasa")) {
            // carico la casa da modificare
            session = request.getSession();
            String idCasa = (String) session.getAttribute("idCasa"); // carico l'id della casa
            Casa c = gestoreCasa.getCasaById(idCasa);
            // modifico i valori
            c.setIndirizzo(request.getParameter("indirizzo"));
            c.setNcivico(request.getParameter("civico"));
            c.setCitta(request.getParameter("citta"));
            String nomeCasa = request.getParameter("nome");
            nomeCasa = Character.toUpperCase(nomeCasa.charAt(0)) + nomeCasa.substring(1);
            c.setNomeCasa(nomeCasa);
            gestoreCasa.editCasa(c);

            String gsonCasa = buildGson(c);
            request.setAttribute("casa", gsonCasa);
            request.setAttribute("location", buildGson("profilo_casa"));

            // carico le info sugli utenti in modo da stamparli tra le informazioni
            List<Long> listUtentiId = c.getUtenti();

            ArrayList<Utente> listUtenti = new ArrayList();
            for (Long ut : listUtentiId) {
                Utente u = gestoreUtente.getUtenteById(ut);
                if (u != null) {
                    listUtenti.add(u);
                }
            }
            String gsonCoinqulini = buildGson(listUtenti);
            request.setAttribute("coinquilini", gsonCoinqulini);

            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/house/profilo_casa.jsp");

        } else if (action.equals("entraInCasa")) {
            String codiceCasa = request.getParameter("codiceCasa");
            Casa c = gestoreCasa.getCasaByCodiceCasa(codiceCasa);
            if (c != null) {
                String email = (String) session.getAttribute("email");
                Utente u = gestoreUtente.getUtenteByEmail(email);
                if (u.getTipoUtente().equals("U")) {
                    c.addInquilino(u);
                    session.setAttribute("idCasa", c.getId());
                    gestoreCasa.editCasa(c);
                    u.setTipoUtente("I");
                    u.setCasa(c);
                    u.setPostUnread(0);
                    gestoreUtente.editUtente(u);
                    String gsonCasa = buildGson(c);
                    gestoreUtente.resetNotifications("post", u.getId());
                    session.setAttribute("idCasa", c.getId());
                    request.setAttribute("casa", gsonCasa);
                    request.setAttribute("location", buildGson("bacheca"));
                    rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/bacheca/bacheca.jsp");
                } else {
                    request.setAttribute("location", buildGson("entraCasa"));
                    request.setAttribute("errore", buildGson("utente_inquilino"));
                    rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/utente/entraCasa.jsp");
                }
            } else {
                Utente u = gestoreUtente.getUtenteByEmail((String) session.getAttribute("email"));
                request.setAttribute("location", buildGson("entraCasa"));
                request.setAttribute("errore", buildGson("casa_assente"));
                rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/utente/entraCasa.jsp");
            }

        } else if (action.equals("abbandonaCasa")) {
            String email = (String) session.getAttribute("email");
            Utente u = gestoreUtente.getUtenteByEmail(email);
            Casa c = u.getCasa();

            u.setTipoUtente("U");
            u.setCasa(null);
            gestoreUtente.editUtente(u);

            c.removeInquilino(u);
            gestoreCasa.editCasa(c);

            request.setAttribute("location", buildGson("home"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");

        } else if (action.equals("profilo_casa")) {
            session = request.getSession();
            String idCasa = (String) session.getAttribute("idCasa"); // carico l'id della casa
            Casa c = gestoreCasa.getCasaById(idCasa);
            String gsonCasa = buildGson(c);
            request.setAttribute("casa", gsonCasa);
            request.setAttribute("location", buildGson("profilo_casa"));

            // carico le info sugli utenti in modo da stamparli tra le informazioni
            List<Long> listUtentiId = c.getUtenti();

            ArrayList<Utente> listUtenti = new ArrayList();
            for (Long ut : listUtentiId) {
                Utente u = gestoreUtente.getUtenteById(ut);
                if (u != null) {
                    listUtenti.add(u);
                }
            }

            String gsonCoinqulini = buildGson(listUtenti);
            request.setAttribute("coinquilini", gsonCoinqulini);

            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/house/profilo_casa.jsp");

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
