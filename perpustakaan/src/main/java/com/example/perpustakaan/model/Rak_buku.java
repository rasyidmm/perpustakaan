package com.example.perpustakaan.model;


import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author rasyid
 */
@Entity
public class Rak_buku extends Additional implements Serializable {

    @OneToMany(mappedBy = "rak_buku")
    private List<Buku> bukus;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100,nullable = false)
    private String nama_rakbuku;

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
        if (!(object instanceof Rak_buku)) {
            return false;
        }
        Rak_buku other = (Rak_buku) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Rak_buku[ id=" + getId() + " ]";
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
     * @return the nama_rakbuku
     */
    public String getNama_rakbuku() {
        return nama_rakbuku;
    }

    /**
     * @param nama_rakbuku the nama_rakbuku to set
     */
    public void setNama_rakbuku(String nama_rakbuku) {
        this.nama_rakbuku = nama_rakbuku;
    }

}
