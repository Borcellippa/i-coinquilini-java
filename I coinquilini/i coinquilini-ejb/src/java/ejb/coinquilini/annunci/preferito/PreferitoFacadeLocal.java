/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.annunci.preferito;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface PreferitoFacadeLocal {

    void create(Preferito preferito);

    void edit(Preferito preferito);

    void remove(Preferito preferito);

    Preferito find(Object id);

    List<Preferito> findAll();

    List<Preferito> findRange(int[] range);

    int count();
    
}
