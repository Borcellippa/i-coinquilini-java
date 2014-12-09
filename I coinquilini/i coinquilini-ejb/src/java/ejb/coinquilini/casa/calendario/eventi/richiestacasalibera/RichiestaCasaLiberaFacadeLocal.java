/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.calendario.eventi.richiestacasalibera;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface RichiestaCasaLiberaFacadeLocal {

    void create(RichiestaCasaLibera richiestaCasaLibera);

    void edit(RichiestaCasaLibera richiestaCasaLibera);

    void remove(RichiestaCasaLibera richiestaCasaLibera);

    RichiestaCasaLibera find(Object id);

    List<RichiestaCasaLibera> findAll();

    List<RichiestaCasaLibera> findRange(int[] range);

    int count();
    
}
