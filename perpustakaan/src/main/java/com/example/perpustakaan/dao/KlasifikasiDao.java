package com.example.perpustakaan.dao;

import com.example.perpustakaan.model.Klasifikasi;

import java.util.List;

public interface KlasifikasiDao {
    public List<Klasifikasi> getAllKlasifikasi();
    public Klasifikasi getById(long id);
    public void SaveOrUpdate(Klasifikasi a);
    public void deleteKlasifikasi(long id);
    public void deleteKlasifikasi(Klasifikasi a);
}
