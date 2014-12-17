/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.wishlist;

import borcellippa.coinquilini.casa.wishlist.wishlistentry.GestoreWishlistEntryLocal;
import borcellippa.coinquilini.casa.wishlist.wishlistentry.WishlistEntry;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Bortignon Gianluca
 */
@Stateless
public class GestoreWishlist implements GestoreWishlistLocal {
    @EJB
    private GestoreWishlistEntryLocal gestoreWishlistEntry;
    @EJB
    private WishlistFacadeLocal wishlistFacade;

    @Override
    public Wishlist getWishlistByHouse(String casaId) {
        return wishlistFacade.getWishlistByHouse(casaId);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Wishlist addEntry(Wishlist w, String descrizione, int quantita) {
        WishlistEntry we = gestoreWishlistEntry.createEntry(w,descrizione,quantita);
        if(we != null){
            w.addEntry(we);
            wishlistFacade.edit(w);
        }
        return wishlistFacade.find(w.getId());
    }

    @Override
    public Wishlist deleteEntry(Wishlist w, Long idEntry) {
        List<WishlistEntry> we = w.getEntries();
        WishlistEntry weOld = gestoreWishlistEntry.getEntry(idEntry);
        we.remove(weOld);
        w.setEntries(we);
        gestoreWishlistEntry.deleteEntry(idEntry);
        wishlistFacade.edit(w);
        return w;
    }
    
}
