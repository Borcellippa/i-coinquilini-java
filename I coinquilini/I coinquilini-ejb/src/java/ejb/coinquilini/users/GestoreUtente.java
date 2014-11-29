/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
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
    public void addUtente(String nome, String cognome, String email, String password, String telefono, String nazionalita, String data_nascita, String citta_natale) {
        Utente u = new Utente();
        u.setNome(nome);
        u.setCognome(cognome);
        u.setEmail(email);
        String hashedPassword = this.hashPassword(password);
        u.setPassword(hashedPassword);
        u.setTelefono(telefono);
        u.setNazionalita(nazionalita);
        u.setData_nascita(data_nascita);
        u.setCitta_natale(citta_natale);
        
        utenteFacade.create(u);
    }
    

    @Override
    public Utente getUtente(String email, String password) {
        Utente u = new Utente();
        return utenteFacade.find(u);
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
    private String hashPassword(String password){
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
        for(byte b: digest){
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    @Override
    public Utente verificaLogin(String email, String password) {
        Utente u = this.getUtenteByEmail(email);
        if(u != null){
            if(this.hashPassword(password).equals(u.getPassword()))
                return u;
        }
        return null;
    }
}
