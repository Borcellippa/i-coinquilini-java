/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.bacheca.post;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface PostFacadeLocal {

    void create(Post post);

    void edit(Post post);

    void remove(Post post);

    Post find(Object id);

    List<Post> findAll();

    List<Post> findRange(int[] range);

    int count();
    
}