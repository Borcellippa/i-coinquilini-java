/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borcellippa.coinquilini.cookies;

import borcellippa.coinquilini.utente.Utente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface UserCookieFacadeLocal {

    void create(UserCookie userCookie);

    void edit(UserCookie userCookie);

    void remove(UserCookie userCookie);

    UserCookie find(Object id);

    List<UserCookie> findAll();

    List<UserCookie> findRange(int[] range);

    int count();

    Utente getUtenteByToken(String token);

    /**
     *
     * @param utente the value of utente
     */
    UserCookie getCookieByUser(borcellippa.coinquilini.utente.Utente utente);
    
}
