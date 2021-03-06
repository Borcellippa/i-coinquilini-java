/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.utente;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface GestoreUtenteLocal {

    List<Utente> getUtenti();

    void addUtente(Utente par0);

    Utente getUtenteByEmail(String email);

    Utente verificaLogin(String email, String password);

    void editUtente(Utente u);

    void editUtentePassword(String pwd, Utente u);

    Utente getUtenteById(Long id);

    void notifyUser(String notifica, Long idUser);

    void resetNotifications(String notifica, Long idUser);
    
}
