/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.users;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Bortignon Gianluca
 */
@Entity
public class Utente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String nome;

    private String cognome;

    private String telefono;

    private int eta;

    private String nazionalita;

    private String g_access_token;

    private String fb_access_token;

    private String fb_user_id;

    private String foto_path;

   // private List<Preferito> preferiti;
    

    /**
     * Get the value of preferiti
     *
     * @return the value of preferiti
     */
  /*  public List<Preferito> getPreferiti() {
        return preferiti;
    }*/

    /**
     * Set the value of preferiti
     *
     * @param preferiti new value of preferiti
     */
  /*  public void setPreferiti(List<Preferito> preferiti) {
        this.preferiti = preferiti;
    }*/

    /**
     * Get the value of foto_path
     *
     * @return the value of foto_path
     */
    public String getFoto_path() {
        return foto_path;
    }

    /**
     * Set the value of foto_path
     *
     * @param foto_path new value of foto_path
     */
    public void setFoto_path(String foto_path) {
        this.foto_path = foto_path;
    }

    /**
     * Get the value of fb_user_id
     *
     * @return the value of fb_user_id
     */
    public String getFb_user_id() {
        return fb_user_id;
    }

    /**
     * Set the value of fb_user_id
     *
     * @param fb_user_id new value of fb_user_id
     */
    public void setFb_user_id(String fb_user_id) {
        this.fb_user_id = fb_user_id;
    }

    /**
     * Get the value of fb_access_token
     *
     * @return the value of fb_access_token
     */
    public String getFb_access_token() {
        return fb_access_token;
    }

    /**
     * Set the value of fb_access_token
     *
     * @param fb_access_token new value of fb_access_token
     */
    public void setFb_access_token(String fb_access_token) {
        this.fb_access_token = fb_access_token;
    }

    /**
     * Get the value of g_access_token
     *
     * @return the value of g_access_token
     */
    public String getG_access_token() {
        return g_access_token;
    }

    /**
     * Set the value of g_access_token
     *
     * @param g_access_token new value of g_access_token
     */
    public void setG_access_token(String g_access_token) {
        this.g_access_token = g_access_token;
    }

    /**
     * Get the value of nazionalita
     *
     * @return the value of nazionalita
     */
    public String getNazionalita() {
        return nazionalita;
    }

    /**
     * Set the value of nazionalita
     *
     * @param nazionalita new value of nazionalita
     */
    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    /**
     * Get the value of eta
     *
     * @return the value of eta
     */
    public int getEta() {
        return eta;
    }

    /**
     * Set the value of eta
     *
     * @param eta new value of eta
     */
    public void setEta(int eta) {
        this.eta = eta;
    }

    /**
     * Get the value of telefono
     *
     * @return the value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Set the value of telefono
     *
     * @param telefono new value of telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Get the value of cognome
     *
     * @return the value of cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Set the value of cognome
     *
     * @param cognome new value of cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Utente[ id=" + id + " ]";
    }
    
}
