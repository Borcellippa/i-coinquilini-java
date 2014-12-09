/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.gestione_economica.borsellino;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface BorsellinoFacadeLocal {

    void create(Borsellino borsellino);

    void edit(Borsellino borsellino);

    void remove(Borsellino borsellino);

    Borsellino find(Object id);

    List<Borsellino> findAll();

    List<Borsellino> findRange(int[] range);

    int count();
    
}
