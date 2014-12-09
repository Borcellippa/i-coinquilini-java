/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.calendario;

import ejb.coinquilini.casa.calendario.eventi.evento.Evento;
import ejb.coinquilini.casa.casa.Casa;
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
public class Calendario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Casa casa;
    private List<Evento> eventi;

    /**
     * Get the value of eventi
     *
     * @return the value of eventi
     */
    public List<Evento> getEventi() {
        return eventi;
    }

    /**
     * Set the value of eventi
     *
     * @param eventi new value of eventi
     */
    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
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
        if (!(object instanceof Calendario)) {
            return false;
        }
        Calendario other = (Calendario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.casa.calendario.Calendario[ id=" + id + " ]";
    }
    
}
