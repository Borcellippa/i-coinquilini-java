/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.users;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface GestoreUtenteLocal {

    List<Utente> getUtenti();

    void addUtente(String nome, String cognome, String email, String password, String telefono, String nazionalita, String data_nascita, String citta_natale);

    Utente getUtente(String email, String password);

    Utente getUtenteByEmail(String email);
    
}
