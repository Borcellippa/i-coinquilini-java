/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.wishlist.wishlistentry;

import borcellippa.coinquilini.casa.wishlist.Wishlist;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Fede
 */
@Entity
public class WishlistEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descrizione;
    private Boolean done;
    private Wishlist wishlist;

    /**
     * Get the value of wishlist
     *
     * @return the value of wishlist
     */
    public Wishlist getWishlist() {
        return wishlist;
    }

    /**
     * Set the value of wishlist
     *
     * @param wishlist new value of wishlist
     */
    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }


    /**
     * Get the value of done
     *
     * @return the value of done
     */
    public Boolean getDone() {
        return done;
    }

    /**
     * Set the value of done
     *
     * @param done new value of done
     */
    public void setDone(Boolean done) {
        this.done = done;
    }


    /**
     * Get the value of descrizione
     *
     * @return the value of descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Set the value of descrizione
     *
     * @param descrizione new value of descrizione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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
        if (!(object instanceof WishlistEntry)) {
            return false;
        }
        WishlistEntry other = (WishlistEntry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.casa.wishlist.WishlistEntry[ id=" + id + " ]";
    }
    
}
