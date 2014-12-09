/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.users.inquilino;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Bortignon Gianluca
 */
@Stateless
public class GestoreInquilino implements GestoreInquilinoLocal {
    @EJB
    private InquilinoFacadeLocal inquilinoFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Inquilino getInquilinoByEmail(String email) {
        return inquilinoFacade.getInquilinoByEmail(email); 
    }
}
