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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "Film")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
    , @NamedQuery(name = "Film.findByTytul", query = "SELECT f FROM Film f WHERE f.tytul = :tytul")
    , @NamedQuery(name = "Film.findByRokProd", query = "SELECT f FROM Film f WHERE f.rokProd = :rokProd")
    , @NamedQuery(name = "Film.findByBoxOffice", query = "SELECT f FROM Film f WHERE f.boxOffice = :boxOffice")
    , @NamedQuery(name = "Film.findByJezyk", query = "SELECT f FROM Film f WHERE f.jezyk = :jezyk")
        ,@NamedQuery(name = "Film.findAllAlpha", query = "SELECT f FROM Film f order by f.tytul")
    , @NamedQuery(name = "Film.findByFilmId", query = "SELECT f FROM Film f WHERE f.filmId = :filmId")})
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "tytul")
    private String tytul;
    @Column(name = "rok_prod")
    private Short rokProd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "box_office")
    private Float boxOffice;
    @Column(name = "jezyk")
    private String jezyk;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "film_id")
    private Integer filmId;
    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "film_kraj",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "kraj_id")
    )
    private Set<Kraj> kraje = new HashSet<>();
    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "film_rezyser",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "rezyser_id")
    )
    Set<Rezyser> rezyserzy = new HashSet<>();
    
    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "film_aktor",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "aktor_id")
    )
    Set<Aktor> aktorzy = new HashSet<>();
    
    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "film_gatunek",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "gatunek_id")
    )
    Set<Gatunek> gatunki = new HashSet<>();

    public Film() {
    }

    public Film(Integer filmId) {
        this.filmId = filmId;
    }

    public Film(Integer filmId, String tytul) {
        this.filmId = filmId;
        this.tytul = tytul;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Short getRokProd() {
        return rokProd;
    }

    public void setRokProd(Short rokProd) {
        this.rokProd = rokProd;
    }

    public Float getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(Float boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getJezyk() {
        return jezyk;
    }

    public void setJezyk(String jezyk) {
        this.jezyk = jezyk;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.tytul);
        hash = 71 * hash + Objects.hashCode(this.rokProd);
        hash = 71 * hash + Objects.hashCode(this.boxOffice);
        hash = 71 * hash + Objects.hashCode(this.jezyk);
        hash = 71 * hash + Objects.hashCode(this.filmId);
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
        final Film other = (Film) obj;
        if (!Objects.equals(this.tytul, other.tytul)) {
            return false;
        }
        if (!Objects.equals(this.jezyk, other.jezyk)) {
            return false;
        }
        if (!Objects.equals(this.rokProd, other.rokProd)) {
            return false;
        }
        if (!Objects.equals(this.boxOffice, other.boxOffice)) {
            return false;
        }
        if (!Objects.equals(this.filmId, other.filmId)) {
            return false;
        }
        return true;
    }





    public Set<Kraj> getKraje() {
        return kraje;
    }

    public void setKraje(Set<Kraj> kraje) {
        this.kraje = kraje;
    }
    
    public void addKraj(Kraj k)
    {
        this.kraje.add(k);
        k.getFilmy().add(this);
    }
    public void deleteKraj(Kraj k)
    {
        this.kraje.remove(k);
        k.getFilmy().remove(this);
    }

    public Set<Rezyser> getRezyserzy() {
        return rezyserzy;
    }
    
    public void setRezyserzy(Set<Rezyser> rezyserzy) {
        this.rezyserzy = rezyserzy;
    }
    public void addRezyser(Rezyser r)
    {
        this.rezyserzy.add(r);
        r.getFilmy().add(this);
    }
    public void deleteRezyser(Rezyser r)
    {
        this.rezyserzy.remove(r);
        r.getFilmy().remove(this);
    }

    public Set<Aktor> getAktorzy() {
        return aktorzy;
    }

    public void setAktorzy(Set<Aktor> aktorzy) {
        this.aktorzy = aktorzy;
    }
    
    public void addAktor(Aktor a)
    {
        this.aktorzy.add(a);
        a.getFilmy().add(this);
    }
    public void deleteAktor(Aktor a)
    {
        this.aktorzy.remove(a);
        a.getFilmy().remove(this);
    }

    public Set<Gatunek> getGatunki() {
        return gatunki;
    }

    public void setGatunki(Set<Gatunek> gatunki) {
        this.gatunki = gatunki;
    }
    
    public void addGatunek(Gatunek g)
    {
        this.gatunki.add(g);
        g.getFilmy().add(this);
    }
    
    public void deleteGatunek(Gatunek g)
    {
        this.gatunki.remove(g);
        g.getFilmy().remove(this);
    }
    
    @Override
    public String toString() {
        return "Film{" + "tytul=" + tytul + ", rokProd=" + rokProd + ", boxOffice=" + boxOffice + ", jezyk=" + jezyk + ", filmId=" + filmId + '}';
    }

    
 
}
