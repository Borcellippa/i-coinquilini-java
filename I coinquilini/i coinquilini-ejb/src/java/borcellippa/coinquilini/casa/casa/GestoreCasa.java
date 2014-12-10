/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.casa;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Fede
 */
@Stateless
public class GestoreCasa implements GestoreCasaLocal {
    
    @EJB
    private CasaFacadeLocal casaFacade;
    
    
    

    @Override
    public void getCasaById() {
    }

    
    
}
