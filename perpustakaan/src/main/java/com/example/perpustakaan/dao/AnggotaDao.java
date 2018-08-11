package com.example.perpustakaan.dao;

import com.example.perpustakaan.model.Anggota;

import java.util.List;

public interface AnggotaDao {
    public List<Anggota> getAllAnggota();
    public Anggota getById(long id);
    public void SaveOrUpdate(Anggota a);
    public void deleteAnggota(long id);
    public void deleteAnggota(Anggota a);
}
