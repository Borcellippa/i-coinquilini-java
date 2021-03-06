/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.calendario.eventi.richiestacasalibera;

import borcellippa.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fede
 */
@Stateless
public class RichiestaCasaLiberaFacade extends AbstractFacade<RichiestaCasaLibera> implements RichiestaCasaLiberaFacadeLocal {
    @PersistenceContext(unitName = "I_coinquilini-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RichiestaCasaLiberaFacade() {
        super(RichiestaCasaLibera.class);
    }
    
}
