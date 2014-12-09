/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.users.inquilino;

import borcellippa.coinquilini.casa.casa.Casa;
import borcellippa.coinquilini.casa.bacheca.post.Post;
import borcellippa.coinquilini.casa.gestione_economica.debito.Debito;
import borcellippa.coinquilini.casa.gestione_economica.spesa.Spesa;
import borcellippa.coinquilini.users.utente.Utente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Fede
 */
@Entity
public class Inquilino extends Utente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inquilino)) {
            return false;
        }
        Inquilino other = (Inquilino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.users.Inquilino[ id=" + id + " ]";
    }
    
}
