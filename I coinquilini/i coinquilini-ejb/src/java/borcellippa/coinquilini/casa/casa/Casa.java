/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.casa;

import borcellippa.coinquilini.casa.bacheca.bacheca.Bacheca;
import borcellippa.coinquilini.casa.calendario.Calendario;
import borcellippa.coinquilini.casa.gruppocase.GruppoCase;
import borcellippa.coinquilini.casa.wishlist.Wishlist;
import borcellippa.coinquilini.users.inquilino.Inquilino;
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
public class Casa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String indirizzo;
    private String ncivico;
    private List<String> imagesPath;
    private int postiTotali;
    private String postiOccupati;
    private String latitudine;
    private String longitudine;
    private int inCasa;
    private Calendario calendario;
    private List<Inquilino> inquilini;
    private Bacheca bacheca;
    private GruppoCase gruppo;
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
     * Get the value of inquilini
     *
     * @return the value of inquilini
     */
    public List<Inquilino> getInquilini() {
        return inquilini;
    }

    /**
     * Set the value of inquilini
     *
     * @param inquilini new value of inquilini
     */
    public void setInquilini(List<Inquilino> inquilini) {
        this.inquilini = inquilini;
    }


    /**
     * Get the value of calendario
     *
     * @return the value of calendario
     */
    public Calendario getCalendario() {
        return calendario;
    }

    /**
     * Set the value of calendario
     *
     * @param calendario new value of calendario
     */
    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    

    /**
     * Get the value of inCasa
     *
     * @return the value of inCasa
     */
    public int getInCasa() {
        return inCasa;
    }

    /**
     * Set the value of inCasa
     *
     * @param inCasa new value of inCasa
     */
    public void setInCasa(int inCasa) {
        this.inCasa = inCasa;
    }

    /**
     * Get the value of longitudine
     *
     * @return the value of longitudine
     */
    public String getLongitudine() {
        return longitudine;
    }

    /**
     * Set the value of longitudine
     *
     * @param longitudine new value of longitudine
     */
    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }


    /**
     * Get the value of lat
     *
     * @return the value of lat
     */
    public String getLatitudine() {
        return latitudine;
    }

    /**
     * Set the value of lat
     *
     * @param latitudine new value of lat
     */
    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }
    
    private String citta;

    /**
     * Get the value of citta
     *
     * @return the value of citta
     */
    public String getCitta() {
        return citta;
    }

    /**
     * Set the value of citta
     *
     * @param citta new value of citta
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }

    /**
     * Get the value of postiOccupati
     *
     * @return the value of postiOccupati
     */
    public String getPostiOccupati() {
        return postiOccupati;
    }

    /**
     * Set the value of postiOccupati
     *
     * @param postiOccupati new value of postiOccupati
     */
    public void setPostiOccupati(String postiOccupati) {
        this.postiOccupati = postiOccupati;
    }

    /**
     * Get the value of postiTotali
     *
     * @return the value of postiTotali
     */
    public int getPostiTotali() {
        return postiTotali;
    }

    /**
     * Set the value of postiTotali
     *
     * @param postiTotali new value of postiTotali
     */
    public void setPostiTotali(int postiTotali) {
        this.postiTotali = postiTotali;
    }


    /**
     * Get the value of imagesPath
     *
     * @return the value of imagesPath
     */
    public List<String> getImagesPath() {
        return imagesPath;
    }

    /**
     * Set the value of imagesPath
     *
     * @param imagesPath new value of imagesPath
     */
    public void setImagesPath(List<String> imagesPath) {
        this.imagesPath = imagesPath;
    }

    /**
     * Get the value of ncivico
     *
     * @return the value of ncivico
     */
    public String getNcivico() {
        return ncivico;
    }

    /**
     * Set the value of ncivico
     *
     * @param ncivico new value of ncivico
     */
    public void setNcivico(String ncivico) {
        this.ncivico = ncivico;
    }


    /**
     * Get the value of indirizzo
     *
     * @return the value of indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Set the value of indirizzo
     *
     * @param indirizzo new value of indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
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
        if (!(object instanceof Casa)) {
            return false;
        }
        Casa other = (Casa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.casa.Casa[ id=" + id + " ]";
    }
    
}
