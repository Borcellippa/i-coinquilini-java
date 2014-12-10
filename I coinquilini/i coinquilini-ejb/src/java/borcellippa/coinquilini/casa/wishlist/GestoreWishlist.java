/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.wishlist;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Bortignon Gianluca
 */
@Stateless
public class GestoreWishlist implements GestoreWishlistLocal {
    @EJB
    private WishlistFacadeLocal wishlistFacade;

    @Override
    public Wishlist getWishlistByHouse(String casaId) {
        return wishlistFacade.getWishlistByHouse(casaId);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
