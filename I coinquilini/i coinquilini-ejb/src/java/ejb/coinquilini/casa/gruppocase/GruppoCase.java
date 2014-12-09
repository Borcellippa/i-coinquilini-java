/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.gruppocase;

import ejb.coinquilini.casa.bacheca.bacheca.Bacheca;
import ejb.coinquilini.casa.casa.Casa;
import ejb.coinquilini.casa.wishlist.Wishlist;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GruppoCase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private List<Casa> listaCase;
    private Wishlist wishlist;
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
     * Get the value of listaCase
     *
     * @return the value of listaCase
     */
    public List<Casa> getListaCase() {
        return listaCase;
    }

    /**
     * Set the value of listaCase
     *
     * @param listaCase new value of listaCase
     */
    public void setListaCase(List<Casa> listaCase) {
        this.listaCase = listaCase;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        if (!(object instanceof GruppoCase)) {
            return false;
        }
        GruppoCase other = (GruppoCase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.casa.gestione_economica.GruppoCase[ id=" + id + " ]";
    }
    
}
