/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.gestione_economica.debito;

import ejb.coinquilini.users.inquilino.Inquilino;
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
public class Debito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float importo;
    private Inquilino debitore;
    private Inquilino creditore;

    /**
     * Get the value of creditore
     *
     * @return the value of creditore
     */
    public Inquilino getCreditore() {
        return creditore;
    }

    /**
     * Set the value of creditore
     *
     * @param creditore new value of creditore
     */
    public void setCreditore(Inquilino creditore) {
        this.creditore = creditore;
    }


    /**
     * Get the value of debitore
     *
     * @return the value of debitore
     */
    public Inquilino getDebitore() {
        return debitore;
    }

    /**
     * Set the value of debitore
     *
     * @param debitore new value of debitore
     */
    public void setDebitore(Inquilino debitore) {
        this.debitore = debitore;
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
        if (!(object instanceof Debito)) {
            return false;
        }
        Debito other = (Debito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.casa.debito.Debito[ id=" + id + " ]";
    }
    
}
