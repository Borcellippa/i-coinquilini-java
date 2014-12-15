/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.wishlist.wishlistentry;

import borcellippa.coinquilini.casa.wishlist.Wishlist;
import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface GestoreWishlistEntryLocal {

    WishlistEntry createEntry(Wishlist w, String descrizione, int quantita);
    
}
