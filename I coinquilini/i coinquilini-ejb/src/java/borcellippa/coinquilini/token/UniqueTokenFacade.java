/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.token;

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
public class UniqueTokenFacade extends AbstractFacade<UniqueToken> implements UniqueTokenFacadeLocal {
    @PersistenceContext(unitName = "I_coinquilini-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UniqueTokenFacade() {
        super(UniqueToken.class);
    }

    @Override
    public UniqueToken getToken() {
        try {
            TypedQuery<UniqueToken> query = em.createQuery("SELECT u FROM UniqueToken u", UniqueToken.class);
            return query.getSingleResult();
        }
        catch(NoResultException e) {
            System.out.println("##### Nessun risultato");
            return null;
        }
        catch(Exception e){
            System.out.println("##### Eccezione generica: "+e.getMessage());
            return new UniqueToken();
        }
    }
    
    
    
}
