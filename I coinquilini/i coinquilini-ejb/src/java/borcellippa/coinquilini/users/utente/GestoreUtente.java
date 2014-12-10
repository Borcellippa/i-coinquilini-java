/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borcellippa.coinquilini.users.utente;

import borcellippa.coinquilini.cookies.GestoreUserCookie;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Bortignon Gianluca
 */
@Stateless
public class GestoreUtente implements GestoreUtenteLocal {

    @EJB
    private UtenteFacadeLocal utenteFacade;

    @Override
    public List<Utente> getUtenti() {
        List<Utente> listaUtenti = utenteFacade.findAll();
        return listaUtenti;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void addUtente(Utente u) {
        String pwd = u.getPassword();
        if (pwd != null) {
            u.setPassword(hashPassword(pwd)); // hasho la password prima di inserirla in db
        }

        utenteFacade.create(u);
    }

    @Override
    public void editUtente(Utente u) {
        utenteFacade.edit(u);

    }

    @Override
    public void editUtentePassword(String pwd, Utente u) {
        u.setPassword(hashPassword(pwd)); // hasho la password prima di inserirla in db
        utenteFacade.edit(u);
    }

    @Override
    public Utente getUtenteByEmail(String email) {
        return utenteFacade.getUtenteByEmail(email);
    }

    /**
     * Funzione che effettua l'hash della password
     *
     * @param password
     * @return L'hash della password
     */
    private String hashPassword(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GestoreUserCookie.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Funzione che effettua l'hash con SHA-256 del token */
        messageDigest.update(password.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    @Override
    public Utente verificaLogin(String email, String password) {
        Utente u = this.getUtenteByEmail(email);
        if (u != null) {
            if (this.hashPassword(password).equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }

}
