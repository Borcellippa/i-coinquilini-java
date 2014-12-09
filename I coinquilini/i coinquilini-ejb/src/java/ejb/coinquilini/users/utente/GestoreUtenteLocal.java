/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.users.utente;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface GestoreUtenteLocal {

    List<Utente> getUtenti();

    void addUtente(ejb.coinquilini.users.utente.Utente par0);

    Utente getUtente(String email, String password);

    Utente getUtenteByEmail(String email);

    Utente verificaLogin(String email, String password);

    void editUtente(Utente u);
    
}
