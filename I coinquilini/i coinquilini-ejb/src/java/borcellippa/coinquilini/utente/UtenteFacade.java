/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.utente;

import borcellippa.AbstractFacade;
import static java.lang.System.exit;
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
public class UtenteFacade extends AbstractFacade<Utente> implements UtenteFacadeLocal {
    @PersistenceContext(unitName = "I_coinquilini-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtenteFacade() {
        super(Utente.class);
    }

    @Override
    public Utente getUtenteByEmail(String email) {
        try {
            TypedQuery<Utente> query = em.createQuery("SELECT u FROM Utente u WHERE u.email ='"+email+"'", Utente.class);
            return query.getSingleResult();
        }
        catch(NoResultException e) {
            System.out.println("##### Nessun risultato");
            return null;
        }
        catch(Exception e){
            System.out.println("##### Eccezione generica: "+e.getMessage());
            return new Utente();
        }
    }
}
