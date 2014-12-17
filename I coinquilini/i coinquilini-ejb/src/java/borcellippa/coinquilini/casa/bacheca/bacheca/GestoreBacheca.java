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
import java.util.ArrayList;
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
    private UtenteFacadeLocal utenteFacade;
    
    @Override
    public List<Post> getPosts(String casaId) {
        Casa c = casaFacade.find(casaId);
        Bacheca b = c.getBacheca();
        List<Post> listaPosts = bachecaFacade.getPosts(b.getId());
        return listaPosts;
    }

    @Override
    public Post addPost(String email_autore, String contenuto, String casa_id) {
        Casa c = casaFacade.find(casa_id);
        Post post = new Post();
        Utente i = utenteFacade.getUtenteByEmail(email_autore);
        post.setAutore(i.getNome()+" "+i.getCognome());
        post.setAutore_img(i.getFoto_path());
        post.setContenuto(contenuto);
        Bacheca b = c.getBacheca();
        Calendar cal = Calendar.getInstance();
        post.setDataPubblicazione(cal.getTime());
        post.setAutore_email(email_autore);
        postFacade.create(post);
        
        List<Post> list = b.getPosts();
        if(list == null)
            list = new ArrayList<>();
        list.add(post);
        b.setPosts(list);
        
        bachecaFacade.edit(b);
        
        System.out.println("### "+list.get(0));
        
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
