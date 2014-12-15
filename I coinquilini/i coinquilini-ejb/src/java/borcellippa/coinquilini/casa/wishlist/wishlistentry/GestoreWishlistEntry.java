/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.wishlist.wishlistentry;

import borcellippa.coinquilini.casa.wishlist.Wishlist;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Bortignon Gianluca
 */
@Stateless
public class GestoreWishlistEntry implements GestoreWishlistEntryLocal {
    @EJB
    private WishlistEntryFacadeLocal wishlistEntryFacade;

    
    
    @Override
    public WishlistEntry createEntry(Wishlist w, String descrizione, int quantita) {
        WishlistEntry we = new WishlistEntry();
        we.setDescrizione(descrizione);
        we.setQuantita(quantita);
        we.setDone(false);
        wishlistEntryFacade.create(we);
        return wishlistEntryFacade.find(we.getId());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
