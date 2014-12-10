/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borcellippa.coinquilini.casa.casa;

import borcellippa.coinquilini.casa.AbstractFacade;
import borcellippa.coinquilini.users.utente.Utente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Fede
 */
@Stateless
public class CasaFacade extends AbstractFacade<Casa> implements CasaFacadeLocal {

    @PersistenceContext(unitName = "I_coinquilini-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasaFacade() {
        super(Casa.class);
    }

    @Override
    public Casa getCasaByCodiceCasa(String codiceCasa) {
        try {
            TypedQuery<Casa> query = em.createQuery("SELECT c FROM Casa c WHERE c.codiceCasa ='" + codiceCasa + "'", Casa.class);
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("##### Nessun risultato");
            return null;
        } catch (Exception e) {
            System.out.println("##### Eccezione generica: " + e.getMessage());
            return new Casa();
        }
    }

}
