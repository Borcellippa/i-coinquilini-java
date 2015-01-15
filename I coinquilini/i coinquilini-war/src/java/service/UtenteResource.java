/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import borcellippa.coinquilini.casa.bacheca.bacheca.Bacheca;
import borcellippa.coinquilini.casa.bacheca.bacheca.GestoreBachecaLocal;
import borcellippa.coinquilini.utente.GestoreUtenteLocal;
import borcellippa.coinquilini.utente.Utente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Bortignon Gianluca
 */
@Path("Utente")
public class UtenteResource {
    GestoreBachecaLocal gestoreBacheca = lookupGestoreBachecaLocal();
    GestoreUtenteLocal gestoreUtente = lookupGestoreUtenteLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UtenteResource
     */
    public UtenteResource() {
    }

    /**
     * Retrieves representation of an instance of service.UtenteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UtenteResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
        
    @POST
    @Path("/validaLogin")
    @Produces("application/json")
    public Utente validaLogin(@FormParam("email") String email,@FormParam("password")  String password) {
        return gestoreUtente.verificaLogin(email, password);
    }
    
    @POST
    @Path("/getUtente")
    @Produces("application/json")
    public Utente getUtente(@FormParam("email") String email) {
        return gestoreUtente.getUtenteByEmail(email);
    }
    
    @POST
    @Path("/testLogin")
    public String testLogin(@FormParam("email") String email,@FormParam("password")  String password) {
        return email+password;
    }
    
    
    @POST
    @Path("/testPost")
    public String testPost() {
        return "CONNESSIONE POST OK!";
    }
    
    @GET
    @Path("/testGet")
    public String testGet() {
        return "CONNESSIONE GET OK!";
    }
    
    
    @GET
    @Path("/getBacheca/{casaId}")
    public Bacheca getBacheca(@PathParam("casaId") String casaId){
        return gestoreBacheca.getBacheca(casaId);
    }
    
    private GestoreUtenteLocal lookupGestoreUtenteLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (GestoreUtenteLocal) c.lookup("java:global/I_coinquilini/I_coinquilini-ejb/GestoreUtente!borcellippa.coinquilini.utente.GestoreUtenteLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private GestoreBachecaLocal lookupGestoreBachecaLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (GestoreBachecaLocal) c.lookup("java:global/I_coinquilini/I_coinquilini-ejb/GestoreBacheca!borcellippa.coinquilini.casa.bacheca.bacheca.GestoreBachecaLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
