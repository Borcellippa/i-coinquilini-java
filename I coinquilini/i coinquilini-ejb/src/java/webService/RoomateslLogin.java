/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webService;

import borcellippa.coinquilini.utente.GestoreUtenteLocal;
import borcellippa.coinquilini.utente.Utente;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.google.gson.Gson;

/**
 *
 * @author Bortignon Gianluca
 */
@WebService(serviceName = "RoomateslLogin")
@Stateless()
public class RoomateslLogin {
    @EJB
    private GestoreUtenteLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    /**
     * Prende le credenziali passate a parametro e se corrette restituisce l'utente formattato in json
     */
    @WebMethod(operationName = "verificaCredenziali")
    public String verificaCredenziali(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        System.out.println("VERIFICO CREDENZIALI "+email+" "+password);
        Utente u = ejbRef.verificaLogin(email, password);
        if(u != null){
            String utenteString = buildGson(u);
            return utenteString;
        }
        else
            return null;
    }
    
    private static String buildGson(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);

        if (json == null) {
            System.out.println("servlet buildGson: NULL");
        } else {
            System.out.println("servlet buildGson: " + json);
        }
        return json;
    }
    
}
