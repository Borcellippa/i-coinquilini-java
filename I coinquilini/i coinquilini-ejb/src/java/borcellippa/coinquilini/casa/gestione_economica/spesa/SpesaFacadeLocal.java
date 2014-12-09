/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.gestione_economica.spesa;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface SpesaFacadeLocal {

    void create(Spesa spesa);

    void edit(Spesa spesa);

    void remove(Spesa spesa);

    Spesa find(Object id);

    List<Spesa> findAll();

    List<Spesa> findRange(int[] range);

    int count();
    
}
