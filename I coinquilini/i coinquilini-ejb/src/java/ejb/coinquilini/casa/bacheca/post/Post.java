/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.bacheca.post;

import ejb.coinquilini.casa.bacheca.bacheca.Bacheca;
import ejb.coinquilini.media.Media;
import ejb.coinquilini.users.inquilino.Inquilino;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Fede
 */
@Entity
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contenuto;
    private Date data;
    private Media media;
    private Inquilino autore;
    private Bacheca bacheca;

    /**
     * Get the value of bacheca
     *
     * @return the value of bacheca
     */
    public Bacheca getBacheca() {
        return bacheca;
    }

    /**
     * Set the value of bacheca
     *
     * @param bacheca new value of bacheca
     */
    public void setBacheca(Bacheca bacheca) {
        this.bacheca = bacheca;
    }


    /**
     * Get the value of autore
     *
     * @return the value of autore
     */
    public Inquilino getAutore() {
        return autore;
    }

    /**
     * Set the value of autore
     *
     * @param autore new value of autore
     */
    public void setAutore(Inquilino autore) {
        this.autore = autore;
    }


    /**
     * Get the value of media
     *
     * @return the value of media
     */
    public Media getMedia() {
        return media;
    }

    /**
     * Set the value of media
     *
     * @param media new value of media
     */
    public void setMedia(Media media) {
        this.media = media;
    }


    /**
     * Get the value of data
     *
     * @return the value of data
     */
    public Date getData() {
        return data;
    }

    /**
     * Set the value of data
     *
     * @param data new value of data
     */
    public void setData(Date data) {
        this.data = data;
    }


    /**
     * Get the value of contenuto
     *
     * @return the value of contenuto
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * Set the value of contenuto
     *
     * @param contenuto new value of contenuto
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.casa.bacheca.post.Post[ id=" + id + " ]";
    }
    
}