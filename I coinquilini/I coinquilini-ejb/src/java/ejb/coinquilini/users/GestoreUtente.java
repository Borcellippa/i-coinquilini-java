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
    public void addUtente(String nome, String cognome) {
        Utente u = new Utente();
        u.setCognome(cognome);
        u.setNome(nome);
        utenteFacade.create(u);
    }
}
