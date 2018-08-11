package com.example.perpustakaan.model;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author rasyid
 */
@Entity
public class Pengarang extends Additional implements Serializable {

    @OneToMany(mappedBy = "pengarang")
    private List<Buku> bukus;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nama_penerbit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pengarang)) {
            return false;
        }
        Pengarang other = (Pengarang) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pengarang[ id=" + getId() + " ]";
    }

    /**
     * @return the bukus
     */
    public List<Buku> getBukus() {
        return bukus;
    }

    /**
     * @param bukus the bukus to set
     */
    public void setBukus(List<Buku> bukus) {
        this.bukus = bukus;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the nama_penerbit
     */
    public String getNama_penerbit() {
        return nama_penerbit;
    }

    /**
     * @param nama_penerbit the nama_penerbit to set
     */
    public void setNama_penerbit(String nama_penerbit) {
        this.nama_penerbit = nama_penerbit;
    }

}
