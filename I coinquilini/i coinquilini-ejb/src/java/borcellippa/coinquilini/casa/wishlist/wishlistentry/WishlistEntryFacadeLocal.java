/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.wishlist.wishlistentry;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface WishlistEntryFacadeLocal {

    void create(WishlistEntry wishlistEntry);

    void edit(WishlistEntry wishlistEntry);

    void remove(WishlistEntry wishlistEntry);

    WishlistEntry find(Object id);

    List<WishlistEntry> findAll();

    List<WishlistEntry> findRange(int[] range);

    int count();
    
}
