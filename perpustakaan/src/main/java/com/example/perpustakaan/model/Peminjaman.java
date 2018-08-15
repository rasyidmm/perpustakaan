package com.example.perpustakaan.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author rasyid
 */
@Entity
public class Peminjaman extends Additional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggal_pinjam;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggal_kembali;
    private Double denda;
    @ManyToOne
    private Buku buku;
    @ManyToOne
    private Anggota anggota;
    @ManyToOne
    private Petugas petugas;

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
        if (!(object instanceof Peminjaman)) {
            return false;
        }
        Peminjaman other = (Peminjaman) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Peminjaman[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the tanggal_pinjam
     */
    public Date getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    /**
     * @param tanggal_pinjam the tanggal_pinjam to set
     */
    public void setTanggal_pinjam(Date tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }

    /**
     * @return the tanggal_kembali
     */
    public Date getTanggal_kembali() {
        return tanggal_kembali;
    }

    /**
     * @param tanggal_kembali the tanggal_kembali to set
     */
    public void setTanggal_kembali(Date tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }

    /**
     * @return the denda
     */
    public Double getDenda() {
        return denda;
    }

    /**
     * @param denda the denda to set
     */
    public void setDenda(Double denda) {
        this.denda = denda;
    }

    /**
     * @return the buku
     */
    public Buku getBuku() {
        return buku;
    }

    /**
     * @param buku the buku to set
     */
    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    /**
     * @return the anggota
     */
    public Anggota getAnggota() {
        return anggota;
    }

    /**
     * @param anggota the anggota to set
     */
    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    /**
     * @return the petugas
     */
    public Petugas getPetugas() {
        return petugas;
    }

    /**
     * @param petugas the petugas to set
     */
    public void setPetugas(Petugas petugas) {
        this.petugas = petugas;
    }

}
