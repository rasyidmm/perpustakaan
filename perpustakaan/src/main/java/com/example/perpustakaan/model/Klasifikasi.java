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
public class Klasifikasi extends Additional implements Serializable {

    @OneToMany(mappedBy = "klasifikasi")
    private List<Buku> bukus;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nama_klasifikasi;

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
        if (!(object instanceof Klasifikasi)) {
            return false;
        }
        Klasifikasi other = (Klasifikasi) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Klasifikasi[ id=" + getId() + " ]";
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
     * @return the nama_klasifikasi
     */
    public String getNama_klasifikasi() {
        return nama_klasifikasi;
    }

    /**
     * @param nama_klasifikasi the nama_klasifikasi to set
     */
    public void setNama_klasifikasi(String nama_klasifikasi) {
        this.nama_klasifikasi = nama_klasifikasi;
    }

}
