/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.coinquilini.users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bortignon Gianluca
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
    
}
