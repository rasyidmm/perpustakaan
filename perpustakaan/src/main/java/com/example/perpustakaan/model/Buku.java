package com.example.perpustakaan.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author rasyid
 */
@Entity
public class Buku extends Additional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String judul_buku;
    private String tahun_buku;
    private String ISBN;
    private Double jumlah_buku;
    private String gambar_buku;
    @ManyToOne
    private Pengarang pengarang;
    @ManyToOne
    private Penerbit penerbit;
    @ManyToOne
    private Klasifikasi klasifikasi;
    @ManyToOne
    private Rak_buku rak_buku;
    @OneToMany(mappedBy = "buku")
    private List<Peminjaman> peminjamans;

    public Buku(Long id, String judul_buku, String tahun_buku, String ISBN) {
        this.id = id;
        this.judul_buku = judul_buku;
        this.tahun_buku = tahun_buku;
        this.ISBN = ISBN;
    }

    public Buku() {
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
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buku)) {
            return false;
        }
        Buku other = (Buku) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Buku[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the judul_buku
     */
    public String getJudul_buku() {
        return judul_buku;
    }

    /**
     * @param judul_buku the judul_buku to set
     */
    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
    }

    /**
     * @return the tahun_buku
     */
    public String getTahun_buku() {
        return tahun_buku;
    }

    /**
     * @param tahun_buku the tahun_buku to set
     */
    public void setTahun_buku(String tahun_buku) {
        this.tahun_buku = tahun_buku;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the jumlah_buku
     */
    public Double getJumlah_buku() {
        return jumlah_buku;
    }

    /**
     * @param jumlah_buku the jumlah_buku to set
     */
    public void setJumlah_buku(Double jumlah_buku) {
        this.jumlah_buku = jumlah_buku;
    }

    /**
     * @return the pengarang
     */
    public Pengarang getPengarang() {
        return pengarang;
    }

    /**
     * @param pengarang the pengarang to set
     */
    public void setPengarang(Pengarang pengarang) {
        this.pengarang = pengarang;
    }

    /**
     * @return the penerbit
     */
    public Penerbit getPenerbit() {
        return penerbit;
    }

    /**
     * @param penerbit the penerbit to set
     */
    public void setPenerbit(Penerbit penerbit) {
        this.penerbit = penerbit;
    }

    /**
     * @return the klasifikasi
     */
    public Klasifikasi getKlasifikasi() {
        return klasifikasi;
    }

    /**
     * @param klasifikasi the klasifikasi to set
     */
    public void setKlasifikasi(Klasifikasi klasifikasi) {
        this.klasifikasi = klasifikasi;
    }

    /**
     * @return the rak_buku
     */
    public Rak_buku getRak_buku() {
        return rak_buku;
    }

    /**
     * @param rak_buku the rak_buku to set
     */
    public void setRak_buku(Rak_buku rak_buku) {
        this.rak_buku = rak_buku;
    }

    /**
     * @return the peminjamans
     */
    public List<Peminjaman> getPeminjamans() {
        return peminjamans;
    }

    /**
     * @param peminjamans the peminjamans to set
     */
    public void setPeminjamans(List<Peminjaman> peminjamans) {
        this.peminjamans = peminjamans;
    }

    public String getGambar_buku() {
        return gambar_buku;
    }

    public void setGambar_buku(String gambar_buku) {
        this.gambar_buku = gambar_buku;
    }
}
