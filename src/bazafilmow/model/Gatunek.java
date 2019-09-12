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
@Table(name = "Gatunek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gatunek.findAll", query = "SELECT g FROM Gatunek g")
    , @NamedQuery(name = "Gatunek.findByGatunekId", query = "SELECT g FROM Gatunek g WHERE g.gatunekId = :gatunekId")
        , @NamedQuery(name = "Gatunek.findAllAlpha", query = "SELECT g FROM Gatunek g order by g.nazwa")
    , @NamedQuery(name = "Gatunek.findByNazwa", query = "SELECT g FROM Gatunek g WHERE g.nazwa = :nazwa")})
public class Gatunek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gatunek_id")
    private Integer gatunekId;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    
    @ManyToMany(mappedBy = "gatunki")
    Set<Film> filmy = new HashSet<>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    public Gatunek() {
    }

    public Gatunek(Integer gatunekId) {
        this.gatunekId = gatunekId;
    }

    public Gatunek(Integer gatunekId, String nazwa) {
        this.gatunekId = gatunekId;
        this.nazwa = nazwa;
    }

    public Integer getGatunekId() {
        return gatunekId;
    }

    public void setGatunekId(Integer gatunekId) {
        this.gatunekId = gatunekId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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
        f.getGatunki().add(this);
    }
    
    public void deleteFilm(Film f)
    {
        this.filmy.remove(f);
        f.getGatunki().remove(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.nazwa);
        return hash;
    }

  

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Gatunek)) {
            return false;
        }
        Gatunek other = (Gatunek) object;
        return this.nazwa.equalsIgnoreCase(other.getNazwa());
    }

    @Override
    public String toString() {
        return "Gatunek{" + "gatunekId=" + gatunekId + ", nazwa=" + nazwa + '}';
    }

    
    
}
