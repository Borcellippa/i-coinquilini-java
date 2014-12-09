/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.wishlist;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bortignon Gianluca
 */
@Stateless
public class WishlistFacade extends AbstractFacade<Wishlist> implements WishlistFacadeLocal {
    @PersistenceContext(unitName = "I_coinquilini-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WishlistFacade() {
        super(Wishlist.class);
    }
    
}
