/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.coinquilini.cookies;

import ejb.coinquilini.users.utente.Utente;
import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface GestoreUserCookieLocal {

    String createUserCookie(String email);

    Utente getUtenteByToken(String token);
    
}
