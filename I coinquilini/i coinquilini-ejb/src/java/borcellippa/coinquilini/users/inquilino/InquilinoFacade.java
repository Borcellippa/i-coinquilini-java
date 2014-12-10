/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.users.inquilino;

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
public class InquilinoFacade extends AbstractFacade<Inquilino> implements InquilinoFacadeLocal {
    @PersistenceContext(unitName = "I_coinquilini-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InquilinoFacade() {
        super(Inquilino.class);
    }

    @Override
    public Inquilino getInquilinoByEmail(String email) {
        try {
            TypedQuery<Inquilino> query = em.createQuery("SELECT u FROM Inquilino u WHERE u.email ='"+email+"'", Inquilino.class);
            return query.getSingleResult();
        }
        catch(NoResultException e) {
            System.out.println("##### Nessun risultato");
            return null;
        }
        catch(Exception e){
            System.out.println("##### Eccezione generica: "+e.getMessage());
            return new Inquilino();
        }
    }
    
}
