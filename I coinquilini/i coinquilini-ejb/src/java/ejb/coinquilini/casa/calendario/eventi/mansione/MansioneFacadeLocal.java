/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.calendario.eventi.mansione;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface MansioneFacadeLocal {

    void create(Mansione mansione);

    void edit(Mansione mansione);

    void remove(Mansione mansione);

    Mansione find(Object id);

    List<Mansione> findAll();

    List<Mansione> findRange(int[] range);

    int count();
    
}
