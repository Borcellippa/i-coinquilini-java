/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borcellippa.coinquilini.users.utente;

import borcellippa.coinquilini.annunci.annuncio.Annuncio;
import borcellippa.coinquilini.casa.casa.Casa;
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
    private String password;
    private String nome;
    private String cognome;
    private String telefono;
    private String data_nascita;
    private String nazionalita;
    private String g_access_token;
    private String fb_access_token;
    private String fb_user_id;
    private String foto_path;
    private String citta_natale;
    private Casa casa;
    private String genere;
    private List<Annuncio> annunci;

    /**
     * Get the value of annunci
     *
     * @return the value of annunci
     */
    public List<Annuncio> getAnnunci() {
        return annunci;
    }

    /**
     * Set the value of annunci
     *
     * @param annunci new value of annunci
     */
    public void setAnnunci(List<Annuncio> annunci) {
        this.annunci = annunci;
    }


    /**
     * Get the value of genere
     *
     * @return the value of genere
     */
    public String getGenere() {
        return genere;
    }

    /**
     * Set the value of genere
     *
     * @param genere new value of genere
     */
    
    public void setGenere(String genere) {
        this.genere = genere;
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
     * Get the value of citta_natale
     *
     * @return the value of citta_natale
     */
    public String getCitta_natale() {
        return citta_natale;
    }

    /**
     * Set the value of citta_natale
     *
     * @param citta_natale new value of citta_natale
     */
    public void setCitta_natale(String citta_natale) {
        this.citta_natale = citta_natale;
    }

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
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

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
     * Get the value of data_nascita
     *
     * @return the value of data_nascita
     */
    public String getData_nascita() {
        return data_nascita;
    }

    /**
     * Set the value of data_nascita
     *
     * @param data_nascita new value of data_nascita
     */
    public void setData_nascita(String data_nascita) {
        this.data_nascita = data_nascita;
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
        return id + " " + nome + " " + cognome + " " + email + " " + genere + " " + password + " " + telefono + " " + data_nascita + " " + nazionalita + " " + g_access_token + " " + fb_access_token + " " + fb_user_id + " " + foto_path + " " + citta_natale;
    }

}
