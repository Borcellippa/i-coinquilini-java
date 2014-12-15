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
    public String createToken() {
        UniqueToken t = uniqueTokenFacade.getToken();
        if(t == null){
            t = new UniqueToken();
            t.setToken("AAAAAA");
            uniqueTokenFacade.create(t);
        }
        else{
            String token = t.getToken();
            StringBuilder newToken = new StringBuilder();
            for(int i=token.length()-1;i>=0;i--){
                if(token.charAt(i) != 'Z'){
                    newToken = new StringBuilder(token);
                    char newChar = token.charAt(i);
                    newChar++;
                    newToken.setCharAt(i, newChar);
                }
            }
            t.setToken(newToken.toString());
            uniqueTokenFacade.edit(t);
        }
        return t.getToken();
    }

    @Override
    public String getToken() {
        return uniqueTokenFacade.getToken().getToken();
    }
}
