/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.wishlist;

import borcellippa.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

    /**
     * Restituisce la wishlist associata ad una casa
     * @param casaId ID della casa della quale si vuole ricercare la wishlsit
     * @return La wishlist associata alla casa
     */
    @Override
    public Wishlist getWishlistByHouse(String casaId) {
        try {
            TypedQuery<Wishlist> query = em.createQuery("SELECT w FROM Wishlist w WHERE w.casa ='"+casaId+"'", Wishlist.class);
            return query.getSingleResult();
        }
        catch(NoResultException e) {
            System.out.println("##### Nessun risultato");
            return null;
        }
        catch(Exception e){
            System.out.println("##### Eccezione generica: "+e.getMessage());
            return new Wishlist();
        }
    }
    
}
