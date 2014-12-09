/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package borcellippa.coinquilini.casa.gestione_economica.spesa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Fede
 */
@Entity
public class Spesa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descrizione;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    private float importo;
    private Boolean pagato;

    /**
     * Get the value of pagato
     *
     * @return the value of pagato
     */
    public Boolean getPagato() {
        return pagato;
    }

    /**
     * Set the value of pagato
     *
     * @param pagato new value of pagato
     */
    public void setPagato(Boolean pagato) {
        this.pagato = pagato;
    }


    /**
     * Get the value of importo
     *
     * @return the value of importo
     */
    public float getImporto() {
        return importo;
    }

    /**
     * Set the value of importo
     *
     * @param importo new value of importo
     */
    public void setImporto(float importo) {
        this.importo = importo;
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
        if (!(object instanceof Spesa)) {
            return false;
        }
        Spesa other = (Spesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.casa.gestione_economica.spesa.Spesa[ id=" + id + " ]";
    }
    
}
