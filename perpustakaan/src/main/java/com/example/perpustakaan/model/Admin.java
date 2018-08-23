package com.example.perpustakaan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Admin extends Additional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic(optional = false)
    @Column(length = 100,nullable = false)
    private String nama_Admin;
    @Column(length = 100,nullable = false)
    private String jenis_kelamin;
    @Column(length = 100,nullable = false)
    private String alamat;
    @Column(length = 100,nullable = false)
    private String telp;
    @Column(length = 100,nullable = false,unique = true)
    private String email;
    @Column(length = 100,nullable = false)
    private String password;
    @Column(length = 100,nullable = false)
    private String foto_Admin;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        if (!(object instanceof Anggota)) {
            return false;
        }
        Anggota other = (Anggota) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Anggota[ id=" + getId() + " ]";
    }


    public String getNama_Admin() {
        return nama_Admin;
    }

    public void setNama_Admin(String nama_Admin) {
        this.nama_Admin = nama_Admin;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto_Admin() {
        return foto_Admin;
    }

    public void setFoto_Admin(String foto_Admin) {
        this.foto_Admin = foto_Admin;
    }
}
