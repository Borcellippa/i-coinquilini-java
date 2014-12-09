/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.gruppocase;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface GruppoCaseFacadeLocal {

    void create(GruppoCase gruppoCase);

    void edit(GruppoCase gruppoCase);

    void remove(GruppoCase gruppoCase);

    GruppoCase find(Object id);

    List<GruppoCase> findAll();

    List<GruppoCase> findRange(int[] range);

    int count();
    
}
