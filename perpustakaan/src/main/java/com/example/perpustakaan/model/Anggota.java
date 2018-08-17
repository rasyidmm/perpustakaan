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
public class Anggota extends Additional implements Serializable {

    @OneToMany(mappedBy = "anggota")
    private List<Peminjaman> peminjamans;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nama_anggota;
    private String jenis_kelamin;
    private String alamat;
    private String telp;
    private String email;
    private String password;
    private String foto_anggota;


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
        if (!(object instanceof Anggota)) {
            return false;
        }
        Anggota other = (Anggota) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Anggota[ id=" + getId() + " ]";
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

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the nama_anggota
     */
    public String getNama_anggota() {
        return nama_anggota;
    }

    /**
     * @param nama_anggota the nama_anggota to set
     */
    public void setNama_anggota(String nama_anggota) {
        this.nama_anggota = nama_anggota;
    }

    /**
     * @return the jenis_kelamin
     */
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    /**
     * @param jenis_kelamin the jenis_kelamin to set
     */
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the telp
     */
    public String getTelp() {
        return telp;
    }

    /**
     * @param telp the telp to set
     */
    public void setTelp(String telp) {
        this.telp = telp;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto_anggota() {
        return foto_anggota;
    }

    public void setFoto_anggota(String foto_anggota) {
        this.foto_anggota = foto_anggota;
    }
}
