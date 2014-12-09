/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.calendario.eventi.evento;

import ejb.coinquilini.casa.calendario.Calendario;
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
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataInizio;
    private String descrizione;
    private Boolean synced;
    private String colore;
    private String ricorrenza;
    private Calendario calendario;

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
     * Get the value of ricorrenza
     *
     * @return the value of ricorrenza
     */
    public String getRicorrenza() {
        return ricorrenza;
    }

    /**
     * Set the value of ricorrenza
     *
     * @param ricorrenza new value of ricorrenza
     */
    public void setRicorrenza(String ricorrenza) {
        this.ricorrenza = ricorrenza;
    }


    /**
     * Get the value of colore
     *
     * @return the value of colore
     */
    public String getColore() {
        return colore;
    }

    /**
     * Set the value of colore
     *
     * @param colore new value of colore
     */
    public void setColore(String colore) {
        this.colore = colore;
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

    /**
     * Get the value of synced
     *
     * @return the value of synced
     */
    public Boolean isSynced() {
        return synced;
    }

    /**
     * Set the value of synced
     *
     * @param synced new value of synced
     */
    public void setSynced(Boolean synced) {
        this.synced = synced;
    }


    /**
     * Get the value of dataInizio
     *
     * @return the value of dataInizio
     */
    public Date getDataInizio() {
        return dataInizio;
    }

    /**
     * Set the value of dataInizio
     *
     * @param dataInizio new value of dataInizio
     */
    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.casa.calendario.eventi.evento.Evento[ id=" + id + " ]";
    }
    
}
