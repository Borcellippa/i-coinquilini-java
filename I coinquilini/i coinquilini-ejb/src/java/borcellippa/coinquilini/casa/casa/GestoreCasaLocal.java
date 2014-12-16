/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borcellippa.coinquilini.casa.casa;

import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface GestoreCasaLocal {

    Casa getCasaByCodiceCasa(String codiceCasa);

    String addCasa(Casa c);

    Casa getCasaById(String idCasa);

    void editCasa(Casa c);

}
