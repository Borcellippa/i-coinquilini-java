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

    
    /**
     * Crea una nuova wishlistEntry
     * @param w La wishlist alla quale associare la entry
     * @param descrizione
     * @param quantita
     * @return L'oggetto wishlistEntry creato
     */
    @Override
    public WishlistEntry createEntry(Wishlist w, String descrizione, int quantita) {
        WishlistEntry we = new WishlistEntry();
        we.setDescrizione(descrizione);
        we.setQuantita(quantita);
        we.setDone(false);
        wishlistEntryFacade.create(we);
        return wishlistEntryFacade.find(we.getId());
    }
    
    @Override
    public WishlistEntry getEntry(Long entryID) {
        return wishlistEntryFacade.find(entryID);
    }

    @Override
    public void deleteEntry(Long idEntry) {
        WishlistEntry we = wishlistEntryFacade.find(idEntry);
        wishlistEntryFacade.remove(we);
    }

    @Override
    public WishlistEntry getWishlistEntry(Long id) {
        return wishlistEntryFacade.find(id);
    }

    @Override
    public void edit(WishlistEntry w) {
        wishlistEntryFacade.edit(w);
    }
    
}
