/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borcellippa.coinquilini.casa.bacheca.bacheca;

import borcellippa.AbstractFacade;
import borcellippa.coinquilini.casa.bacheca.post.Post;
import java.util.List;
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
public class BachecaFacade extends AbstractFacade<Bacheca> implements BachecaFacadeLocal {

    @PersistenceContext(unitName = "I_coinquilini-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BachecaFacade() {
        super(Bacheca.class);
    }

    @Override
    public List<Post> getPosts(Long bacheca_id) {
        try {
            TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p"
                    + "WHERE p.BACHECA_ID = '" + bacheca_id + "'", Post.class
            );
            return query.getResultList();
        } catch (NoResultException e) {
            System.out.println("##### Nessun risultato");
            return null;
        }
    }    
}
