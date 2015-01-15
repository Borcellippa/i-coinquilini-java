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

    /**
     * Crea un oggetto wishlistEntry, lo aggiunge alla wishlist e lo salva sul database
     * @param w La wishlist alla quale aggiungere la entry
     * @param descrizione La descrizione della entry
     * @param quantita Quantità della entry
     * @return La wishlist aggiornata con il nuovo oggetto
     */
    @Override
    public Wishlist addEntry(Wishlist w, String descrizione, int quantita) {
        WishlistEntry we = gestoreWishlistEntry.createEntry(w,descrizione,quantita);
        if(we != null){
            w.addEntry(we);
            wishlistFacade.edit(w);
        }
        return wishlistFacade.find(w.getId());
    }

    /**
     * Elimina una entry della wishlist in base al'ID
     * @param w La wishlist dalla quale eliminare la entry
     * @param idEntry ID della entry
     * @return La wishlist aggiornata senza la entry
     */
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
