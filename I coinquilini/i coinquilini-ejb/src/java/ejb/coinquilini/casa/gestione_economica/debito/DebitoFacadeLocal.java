/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.gestione_economica.debito;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface DebitoFacadeLocal {

    void create(Debito debito);

    void edit(Debito debito);

    void remove(Debito debito);

    Debito find(Object id);

    List<Debito> findAll();

    List<Debito> findRange(int[] range);

    int count();
    
}
