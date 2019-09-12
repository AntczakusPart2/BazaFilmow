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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "Aktor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aktor.findAll", query = "SELECT a FROM Aktor a")
    , @NamedQuery(name = "Aktor.findByAktorId", query = "SELECT a FROM Aktor a WHERE a.aktorId = :aktorId")
    , @NamedQuery(name = "Aktor.findByImie", query = "SELECT a FROM Aktor a WHERE a.imie = :imie")
    , @NamedQuery(name = "Aktor.findByNazwisko", query = "SELECT a FROM Aktor a WHERE a.nazwisko = :nazwisko")
    , @NamedQuery(name = "Aktor.findByNarodowosc", query = "SELECT a FROM Aktor a WHERE a.narodowosc = :narodowosc")
    , @NamedQuery(name = "Aktor.findAllAlpha", query = "SELECT a FROM Aktor a order by a.nazwisko")
    , @NamedQuery(name = "Aktor.findByDataUrodzenia", query = "SELECT a FROM Aktor a WHERE a.dataUrodzenia = :dataUrodzenia")})
public class Aktor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aktor_id")
    private Integer aktorId;
    @Basic(optional = false)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "narodowosc")
    private String narodowosc;
    @Column(name = "data_urodzenia")
    private String dataUrodzenia;
    
    @ManyToMany(mappedBy = "aktorzy")
    Set<Film> filmy = new HashSet<>();
    
    public Aktor() {
    }

    public Aktor(Integer aktorId) {
        this.aktorId = aktorId;
    }

    public Aktor(Integer aktorId, String imie, String nazwisko, String narodowosc) {
        this.aktorId = aktorId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.narodowosc = narodowosc;
    }

    public Integer getAktorId() {
        return aktorId;
    }

    public void setAktorId(Integer aktorId) {
        this.aktorId = aktorId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNarodowosc() {
        return narodowosc;
    }

    public void setNarodowosc(String narodowosc) {
        this.narodowosc = narodowosc;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
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
        f.getAktorzy().add(this);
    }
    public void deleteFilm(Film f)
    {
        f.getAktorzy().remove(this);
        this.getFilmy().remove(f);
    }
    //TODO: implementacja preremove 
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.imie);
        hash = 41 * hash + Objects.hashCode(this.nazwisko);
        hash = 41 * hash + Objects.hashCode(this.narodowosc);
        hash = 41 * hash + Objects.hashCode(this.dataUrodzenia);
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
        final Aktor other = (Aktor) obj;
        if (!Objects.equals(this.imie, other.imie)) {
            return false;
        }
        if (!Objects.equals(this.nazwisko, other.nazwisko)) {
            return false;
        }
        if (!Objects.equals(this.narodowosc, other.narodowosc)) {
            return false;
        }
        if (!Objects.equals(this.dataUrodzenia, other.dataUrodzenia)) {
            return false;
        }
        return true;
    }

    
    

    @Override
    public String toString() {
        return "Aktor{" + "aktorId=" + aktorId + ", imie=" + imie + ", nazwisko=" + nazwisko + ", narodowosc=" + narodowosc + ", dataUrodzenia=" + dataUrodzenia + '}';
    }


    
    
}
