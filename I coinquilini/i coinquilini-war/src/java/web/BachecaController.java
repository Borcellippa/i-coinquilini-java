/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import borcellippa.coinquilini.casa.bacheca.bacheca.GestoreBacheca;
import borcellippa.coinquilini.casa.bacheca.bacheca.GestoreBachecaLocal;
import borcellippa.coinquilini.casa.bacheca.post.Post;
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
import static utility.Utility.buildGson;

/**
 *
 * @author Fede
 */
@WebServlet(name = "BachecaController", urlPatterns = {"/BachecaController"})
public class BachecaController extends HttpServlet {

    @EJB
    private GestoreBachecaLocal gestoreBacheca;

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

        HttpSession session = request.getSession();

        if (action == null) {
            request.setAttribute("location", buildGson("home"));
            rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/home.jsp");

        } /*else if (action.equals("bacheca")) {
         session = request.getSession();
         String idCasa = (String) session.getAttribute("idCasa");
         List<Post> listaPosts = gestoreBacheca.getPosts(idCasa);

         request.setAttribute("location", buildGson("dashboard"));
         request.setAttribute("posts", buildGson(listaPosts));
         rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/home/dashboard.jsp");
        
        }*/ else if (action.equals("addPost")) {
            Post p = new Post();
            
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
