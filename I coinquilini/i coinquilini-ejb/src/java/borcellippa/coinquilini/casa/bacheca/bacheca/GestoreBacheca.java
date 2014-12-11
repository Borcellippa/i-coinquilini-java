/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.bacheca.bacheca;

import borcellippa.coinquilini.casa.bacheca.post.Post;
import borcellippa.coinquilini.casa.bacheca.post.PostFacadeLocal;
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
    private BachecaFacadeLocal bachecaFacade;
    @EJB
    private PostFacadeLocal postFacade;
    @EJB
    private UtenteFacadeLocal inquilinoFacade;
    
    @Override
    public List<Post> getPosts(String casaId) {
        List<Post> listaPosts = bachecaFacade.getPosts(casaId);
        return listaPosts;
    }

    @Override
    public Post addPost(String email_autore, String contenuto, String bacheca_id, String casa_id) {
        Post post = new Post();
        Utente i = inquilinoFacade.getUtenteByEmail(email_autore);
        post.setAutore(i);
        post.setContenuto(contenuto);
        Bacheca b = bachecaFacade.getBacheca(casa_id);
        post.setBacheca(b);
        Calendar cal = Calendar.getInstance();
        post.setDataPubblicazione(cal.getTime());
        postFacade.create(post);
        return post;
    }

    @Override
    public Bacheca getBacheca(String casaId) {
        Bacheca bacheca = bachecaFacade.getBacheca(casaId);
        return bacheca;
    }

    @Override
    public void eliminaPost(String idPost) {
        Post post = postFacade.find(idPost);
        postFacade.remove(post);
    }
}
