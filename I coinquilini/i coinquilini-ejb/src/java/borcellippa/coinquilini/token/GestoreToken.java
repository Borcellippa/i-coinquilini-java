/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.token;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Bortignon Gianluca
 */
@Stateless
public class GestoreToken implements GestoreTokenLocal {
    @EJB
    private UniqueTokenFacadeLocal uniqueTokenFacade;

    @Override
    public void createToken(String token) {
        UniqueToken t = uniqueTokenFacade.getToken();
        
        t.setToken(token);
        uniqueTokenFacade.create(t);
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String getToken() {
        return uniqueTokenFacade.getToken().getToken();
    }
}
