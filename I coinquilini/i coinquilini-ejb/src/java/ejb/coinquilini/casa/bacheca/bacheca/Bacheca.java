/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.coinquilini.casa.bacheca.bacheca;

import ejb.coinquilini.casa.casa.Casa;
import ejb.coinquilini.casa.bacheca.post.Post;
import ejb.coinquilini.casa.gruppocase.GruppoCase;
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
public class Bacheca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private List<Post> posts;
    private Casa casa;
    private GruppoCase gruppo;

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
     * Get the value of posts
     *
     * @return the value of posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Set the value of posts
     *
     * @param posts new value of posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
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
        if (!(object instanceof Bacheca)) {
            return false;
        }
        Bacheca other = (Bacheca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.coinquilini.casa.bacheca.bacheca.Bacheca[ id=" + id + " ]";
    }
    
}
