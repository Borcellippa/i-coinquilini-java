/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borcellippa.coinquilini.cookies;

import borcellippa.AbstractFacade;
import borcellippa.coinquilini.utente.Utente;
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
public class UserCookieFacade extends AbstractFacade<UserCookie> implements UserCookieFacadeLocal {
    @PersistenceContext(unitName = "I_coinquilini-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserCookieFacade() {
        super(UserCookie.class);
    }

    @Override
    public Utente getUtenteByToken(String token) {
        try {
            TypedQuery<Utente> query = em.createQuery("SELECT u.utente FROM UserCookie u WHERE u.token ='"+token+"'", Utente.class);
            return query.getSingleResult();
        }
        catch(NoResultException e) {
            System.out.println("##### Nessun risultato");
            return null;
        }
        catch(Exception e){
            System.out.println("##### Eccezione generica: "+e.getMessage());
            return null;
        }
    }

    /**
     *
     * @param utente the value of utente
     */
    @Override
    public UserCookie getCookieByUser(Utente utente) {
        try {
            TypedQuery<UserCookie> query = em.createQuery("SELECT u FROM UserCookie u WHERE u.utente.id ='"+utente.getId()+"'", UserCookie.class);
            return query.getSingleResult();
        }
        catch(NoResultException e) {
            System.out.println("##### Nessun risultato");
            return null;
        }
        catch(Exception e){
            System.out.println("##### Eccezione generica: "+e.getMessage());
            return null;
        }
    }
    
    
    
}
