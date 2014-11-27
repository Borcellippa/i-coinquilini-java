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
public interface UserCookieFacadeLocal {

    void create(UserCookie userCookie);

    void edit(UserCookie userCookie);

    void remove(UserCookie userCookie);

    UserCookie find(Object id);

    List<UserCookie> findAll();

    List<UserCookie> findRange(int[] range);

    int count();

    Utente getUtenteByToken(String token);
    
}
