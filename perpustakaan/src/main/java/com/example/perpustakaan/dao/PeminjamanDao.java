package com.example.perpustakaan.dao;

import com.example.perpustakaan.model.Peminjaman;

import java.util.List;

public interface PeminjamanDao {
    public List<Peminjaman> getAllPeminjaman();
    public Peminjaman getById(long id);
    public void SaveOrUpdate(Peminjaman a);
    public void deletePeminjaman(long id);
    public void deletePeminjaman(Peminjaman a);
}
