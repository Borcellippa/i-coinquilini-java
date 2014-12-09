/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borcellippa.coinquilini.users.inquilino;

import borcellippa.coinquilini.casa.bacheca.post.Post;
import borcellippa.coinquilini.casa.casa.Casa;
import borcellippa.coinquilini.casa.gestione_economica.debito.Debito;
import borcellippa.coinquilini.casa.gestione_economica.spesa.Spesa;
import borcellippa.coinquilini.users.utente.Utente;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class Inquilino extends Utente {

    private Casa casa;
    private float affitto;
    private List<Debito> debiti;
    private List<Spesa> spese;
    private List<Post> posts;

    /**
     * Get the value of posts
     *
     * @return the value of posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Set the value of posts
     *
     * @param posts new value of posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Get the value of spese
     *
     * @return the value of spese
     */
    public List<Spesa> getSpese() {
        return spese;
    }

    /**
     * Set the value of spese
     *
     * @param spese new value of spese
     */
    public void setSpese(List<Spesa> spese) {
        this.spese = spese;
    }

    /**
     * Get the value of debiti
     *
     * @return the value of debiti
     */
    public List<Debito> getDebiti() {
        return debiti;
    }

    /**
     * Set the value of debiti
     *
     * @param debiti new value of debiti
     */
    public void setDebiti(List<Debito> debiti) {
        this.debiti = debiti;
    }

    /**
     * Get the value of affitto
     *
     * @return the value of affitto
     */
    public float getAffitto() {
        return affitto;
    }

    /**
     * Set the value of affitto
     *
     * @param affitto new value of affitto
     */
    public void setAffitto(float affitto) {
        this.affitto = affitto;
    }

    /**
     * Get the value of casa
     *
     * @return the value of casa
     */
    public Casa getCasa() {
        return casa;
    }

    /**
     * Set the value of casa
     *
     * @param casa new value of casa
     */
    public void setCasa(Casa casa) {
        this.casa = casa;
    }

}
