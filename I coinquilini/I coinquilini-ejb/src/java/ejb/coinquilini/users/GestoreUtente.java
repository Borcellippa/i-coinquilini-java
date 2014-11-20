/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.users;

import java.util.List;
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
        u.setPassword(password);
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
}
