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
@Table(name = "Rezyser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rezyser.findAll", query = "SELECT r FROM Rezyser r")
    , @NamedQuery(name = "Rezyser.findByRezyserId", query = "SELECT r FROM Rezyser r WHERE r.rezyserId = :rezyserId")
    , @NamedQuery(name = "Rezyser.findByImie", query = "SELECT r FROM Rezyser r WHERE r.imie = :imie")
    , @NamedQuery(name = "Rezyser.findByNazwisko", query = "SELECT r FROM Rezyser r WHERE r.nazwisko = :nazwisko")
    , @NamedQuery(name = "Rezyser.findByNarodowosc", query = "SELECT r FROM Rezyser r WHERE r.narodowosc = :narodowosc")
        , @NamedQuery(name = "Rezyser.findAllAlpha", query = "SELECT r FROM Rezyser r order by r.nazwisko")
    , @NamedQuery(name = "Rezyser.findByDataUrodzenia", query = "SELECT r FROM Rezyser r WHERE r.dataUrodzenia = :dataUrodzenia")})
public class Rezyser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rezyser_id")
    private Integer rezyserId;
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
    
    @ManyToMany(mappedBy = "rezyserzy")
    private Set<Film> filmy = new HashSet<>();
    public Rezyser() {
    }

    public Rezyser(Integer rezyserId) {
        this.rezyserId = rezyserId;
    }

    public Rezyser(Integer rezyserId, String imie, String nazwisko, String narodowosc) {
        this.rezyserId = rezyserId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.narodowosc = narodowosc;
    }

    public Integer getRezyserId() {
        return rezyserId;
    }

    public void setRezyserId(Integer rezyserId) {
        this.rezyserId = rezyserId;
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
        f.getRezyserzy().add(this);
    }
    public void deleteFilm(Film f)
    {
        this.filmy.remove(f);
        f.getRezyserzy().remove(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Rezyser other = (Rezyser) obj;
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
        return "Rezyser{" + "rezyserId=" + rezyserId + ", imie=" + imie + ", nazwisko=" + nazwisko + ", narodowosc=" + narodowosc + ", dataUrodzenia=" + dataUrodzenia + '}';
    }

    
}
