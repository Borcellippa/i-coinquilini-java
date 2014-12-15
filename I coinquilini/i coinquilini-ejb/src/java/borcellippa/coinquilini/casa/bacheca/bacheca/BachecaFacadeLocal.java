/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.bacheca.bacheca;

import borcellippa.coinquilini.casa.bacheca.post.Post;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface BachecaFacadeLocal {

    void create(Bacheca bacheca);

    void edit(Bacheca bacheca);

    void remove(Bacheca bacheca);

    Bacheca find(Object id);

    List<Bacheca> findAll();

    List<Bacheca> findRange(int[] range);

    int count();

    List<Post> getPosts(Long bacheca_id);    
}
