/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borcellippa.coinquilini.cookies;

import borcellippa.coinquilini.utente.Utente;
import borcellippa.coinquilini.utente.UtenteFacadeLocal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Bortignon Gianluca
 */
@Stateless
public class GestoreUserCookie implements GestoreUserCookieLocal {
    @EJB
    private UtenteFacadeLocal utenteFacade;
    @EJB
    private UserCookieFacadeLocal userCookieFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     * Funzione che a partire dall'email dell'utente genera lo UserCookie da
     * inserire nel database e restituisce il token da salvare nel cookie
     * 
     * @param email Email dell'utente 
     * @return Il token generato da inserire nel cookie
     */
    @Override
    public String createUserCookie(String email) {
        Utente u = utenteFacade.getUtenteByEmail(email);
        UserCookie actualCookie = userCookieFacade.getCookieByUser(u);
        /* Se un cookie è già presente nel db lo si elimina prima di inserire il nuovo */
        if(actualCookie != null)
            userCookieFacade.remove(actualCookie);
        UserCookie uc = new UserCookie();
        uc.setUtente(u);
        String token = hashEmail(email);
        uc.setToken(token);
        userCookieFacade.create(uc);
        return token;
    }
    
    /**
     * Funzione che a partire dall'email genera il token da salvare 
     * nel cookie e nel database
     * 
     * @param email Email dell'utente 
     * @return Il token generato da inserire nel cookie
     */
    private String hashEmail(String email){
        Date date= new Date();
        /* Il token viene creato concatenando l'email al timestamp */
        String stringToEncrypt = email+date.getTime();
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GestoreUserCookie.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Funzione che effettua l'hash con SHA-256 del token */
        messageDigest.update(stringToEncrypt.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuffer sb = new StringBuffer();
        for(byte b: digest){
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    @Override
    public Utente getUtenteByToken(String token) {
        return userCookieFacade.getUtenteByToken(token);
    }
}
