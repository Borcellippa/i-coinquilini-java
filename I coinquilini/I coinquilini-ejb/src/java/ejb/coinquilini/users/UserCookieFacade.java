/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.coinquilini.users;

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
            TypedQuery<Utente> query = em.createQuery("SELECT u FROM UserCookie u WHERE u.token ='"+token+"'", Utente.class);
            return query.getSingleResult();
        }
        catch(Exception e){
            System.out.println("##### Eccezione generica: "+e.getMessage());
            return null;
        }
    }
    
}
