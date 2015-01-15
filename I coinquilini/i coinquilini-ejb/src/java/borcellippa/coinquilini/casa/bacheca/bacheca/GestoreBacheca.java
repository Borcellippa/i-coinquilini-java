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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
    private CasaFacadeLocal casaFacade;
    @EJB
    private UtenteFacadeLocal utenteFacade;
    
    /**
     * Dato l'id della casa restituisce la lista dei post presenti nella bacheca associata
     * @param casaId Id della casa di interesse
     * @return La lista dei post associati alla casa
     */
    @Override
    public List<Post> getPosts(String casaId) {
        Casa c = casaFacade.find(casaId);
        Bacheca b = c.getBacheca();
        List<Post> listaPosts = bachecaFacade.getPosts(b.getId());
        return listaPosts;
    }

    /**
     * Inserisce un nuovo post nella bacheca
     * @param email_autore Email dell'autore
     * @param contenuto Ciò che verrà mostrato nel post
     * @param casa_id Id della casa associata alla bacheca
     * @return L'oggetto post creato
     */
    @Override
    public Post addPost(String email_autore, String contenuto, String casa_id) {
        Casa c = casaFacade.find(casa_id);
        Post post = new Post();
        Utente i = utenteFacade.getUtenteByEmail(email_autore);
        post.setAutore(i.getNome()+" "+i.getCognome());
        post.setAutore_img(i.getFoto_path());
        post.setContenuto(contenuto);
        Bacheca b = c.getBacheca();
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("dd/MM/yyyy HH:mm");
        post.setDataPubblicazione(cal.getTime().toString());
        post.setAutore_email(email_autore);
        postFacade.create(post);
        List<Post> list = b.getPosts();
        if(list == null)
            list = new ArrayList<>();
        list.add(post);
        b.setPosts(list);
        bachecaFacade.edit(b);
        return post;
    }

    /**
     * Restituisce la bacheca associata alla casa
     * @param casaId La casa della quale si vuole ottenere la bacheca
     * @return L'oggetto Bacheca
     */
    @Override
    public Bacheca getBacheca(String casaId) {
        Casa c = casaFacade.find(casaId);
        if(c != null)
            return c.getBacheca();
        else
            return null;
    }

    /**
     * Elimina un post
     * @param b La bacheca che contiene il post da eliminare
     * @param idPost Id del post che si vuole eliminare
     */
    @Override
    public void eliminaPost(Bacheca b, Long idPost) {
        Post p = postFacade.find(idPost);
        postFacade.remove(p);
        List<Post> list = b.getPosts();
        list.remove(p);
        b.setPosts(list);
        bachecaFacade.edit(b);
    }
}
