/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.bacheca.bacheca;

import borcellippa.coinquilini.casa.bacheca.post.Post;
import borcellippa.coinquilini.casa.bacheca.post.PostFacadeLocal;
import borcellippa.coinquilini.casa.casa.Casa;
import borcellippa.coinquilini.casa.casa.CasaFacadeLocal;
import borcellippa.coinquilini.utente.Utente;
import borcellippa.coinquilini.utente.UtenteFacadeLocal;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Fede
 */
@Stateless
public class GestoreBacheca implements GestoreBachecaLocal {

    @EJB
    private GestoreBachecaLocal gestoreBacheca;
    @EJB
    private BachecaFacadeLocal bachecaFacade;
    @EJB
    private PostFacadeLocal postFacade;
    @EJB
    private CasaFacadeLocal casaFacade;
    @EJB
    private UtenteFacadeLocal inquilinoFacade;
    
    @Override
    public List<Post> getPosts(String casaId) {
        Casa c = casaFacade.find(casaId);
        Bacheca b = c.getBacheca();
        List<Post> listaPosts = bachecaFacade.getPosts(b.getId());
        return listaPosts;
    }

    @Override
    public Post addPost(String email_autore, String contenuto, Long bacheca_id, String casa_id) {
        Casa c = casaFacade.find(casa_id);
        Post post = new Post();
        Utente i = inquilinoFacade.getUtenteByEmail(email_autore);
        post.setAutore(i);
        post.setContenuto(contenuto);
        Bacheca b = c.getBacheca();
        Calendar cal = Calendar.getInstance();
        post.setDataPubblicazione(cal.getTime());
        postFacade.create(post);
        
        List<Post> list = b.getPosts();
        list.add(post);
        
        // aggiorno la lista di post
        b.setPosts(list);
        
        return post;
    }

    @Override
    public Bacheca getBacheca(String casaId) {
        Casa c = casaFacade.find(casaId);
        return c.getBacheca();
    }

    @Override
    public void eliminaPost(String idPost) {
        Post post = postFacade.find(idPost);
        postFacade.remove(post);
    }
}
