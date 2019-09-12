/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "Kraj", uniqueConstraints = {@UniqueConstraint(columnNames = {"nazwa"}) })
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kraj.findAll", query = "SELECT k FROM Kraj k")
    , @NamedQuery(name = "Kraj.findByKrajId", query = "SELECT k FROM Kraj k WHERE k.krajId = :krajId")
        , @NamedQuery(name = "Kraj.findAllAlpha", query = "SELECT k FROM Kraj k order by k.nazwa")
    , @NamedQuery(name = "Kraj.findByNazwa", query = "SELECT k FROM Kraj k WHERE k.nazwa = :nazwa")})
public class Kraj implements Serializable,Comparable<Kraj> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kraj_id")
    private Integer krajId;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
        
    @ManyToMany(mappedBy = "kraje")
    private Set<Film> filmy = new HashSet<>();

    public Kraj() {
    }

    public Kraj(Integer krajId) {
        this.krajId = krajId;
    }

    public Kraj(Integer krajId, String nazwa) {
        this.krajId = krajId;
        this.nazwa = nazwa;
    }

    public Integer getKrajId() {
        return krajId;
    }

    public void setKrajId(Integer krajId) {
        this.krajId = krajId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nazwa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kraj other = (Kraj) obj;
        if (!Objects.equals(this.nazwa, other.nazwa)) {
            return false;
        }
        return true;
    }



    public Set<Film> getFilmy() {
        return filmy;
    }

    public void setFilmy(Set<Film> filmy) {
        this.filmy = filmy;
    }
    public void addFilm(Film f)
    {
        this.filmy.add(f);
        f.getKraje().add(this);
    }
    public void deleteFilm(Film f)
    {
        this.filmy.remove(f);
        f.getKraje().remove(this);
    }
    
    @Override
    public String toString() {
        return "Kraj{" + "krajId=" + krajId + ", nazwa=" + nazwa + '}';
    }

    @Override
    public int compareTo(Kraj o) {
        return this.getNazwa().compareToIgnoreCase(o.getNazwa());
    }

    
    
}
