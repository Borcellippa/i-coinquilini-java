/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.users.inquilino;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
