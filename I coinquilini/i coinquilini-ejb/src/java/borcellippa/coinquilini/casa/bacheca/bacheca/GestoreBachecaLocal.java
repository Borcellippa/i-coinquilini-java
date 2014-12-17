/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.bacheca.bacheca;

import borcellippa.coinquilini.casa.bacheca.post.Post;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fede
 */
@Local
public interface GestoreBachecaLocal {

    List<Post> getPosts(String casaId);

    Post addPost(String email_autore, String contenuto, String casa_id);

    Bacheca getBacheca(String casa_id);

    void eliminaPost(Bacheca b, Long idPost);
}
