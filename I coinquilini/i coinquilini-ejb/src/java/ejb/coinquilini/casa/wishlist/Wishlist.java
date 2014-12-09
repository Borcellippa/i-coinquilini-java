/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.wishlist;

import ejb.coinquilini.casa.wishlist.wishlistentry.WishlistEntry;
import ejb.coinquilini.casa.casa.Casa;
import ejb.coinquilini.casa.gruppocase.GruppoCase;
import ejb.coinquilini.casa.gestione_economica.borsellino.Borsellino;
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
public class Wishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private GruppoCase gruppo;
    private Casa casa;
    private Borsellino borsellino;
    private List<WishlistEntry> entries;

    /**
     * Get the value of entries
     *
     * @return the value of entries
     */
    public List<WishlistEntry> getEntries() {
        return entries;
    }

    /**
     * Set the value of entries
     *
     * @param entries new value of entries
     */
    public void setEntries(List<WishlistEntry> entries) {
        this.entries = entries;
    }


    /**
     * Get the value of borsellino
     *
     * @return the value of borsellino
     */
    public Borsellino getBorsellino() {
        return borsellino;
    }

    /**
     * Set the value of borsellino
     *
     * @param borsellino new value of borsellino
     */
    public void setBorsellino(Borsellino borsellino) {
        this.borsellino = borsellino;
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


    /**
     * Get the value of gruppo
     *
     * @return the value of gruppo
     */
    public GruppoCase getGruppo() {
        return gruppo;
    }

    /**
     * Set the value of gruppo
     *
     * @param gruppo new value of gruppo
     */
    public void setGruppo(GruppoCase gruppo) {
        this.gruppo = gruppo;
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
        if (!(object instanceof Wishlist)) {
            return false;
        }
        Wishlist other = (Wishlist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.casa.wishlist.Wishlist[ id=" + id + " ]";
    }
    
}
