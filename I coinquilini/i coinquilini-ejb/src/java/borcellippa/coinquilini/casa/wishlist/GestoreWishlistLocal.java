/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.wishlist;

import javax.ejb.Local;

/**
 *
 * @author Bortignon Gianluca
 */
@Local
public interface GestoreWishlistLocal {

    Wishlist getWishlistByHouse(String casaId);

    Wishlist addEntry(Wishlist w, String descrizione, int quantita);
    
}
