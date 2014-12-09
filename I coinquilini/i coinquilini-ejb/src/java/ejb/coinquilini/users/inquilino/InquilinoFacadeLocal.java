/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.users.inquilino;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface InquilinoFacadeLocal {

    void create(Inquilino inquilino);

    void edit(Inquilino inquilino);

    void remove(Inquilino inquilino);

    Inquilino find(Object id);

    List<Inquilino> findAll();

    List<Inquilino> findRange(int[] range);

    int count();
    
}
