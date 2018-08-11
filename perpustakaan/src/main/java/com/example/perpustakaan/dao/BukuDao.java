package com.example.perpustakaan.dao;

import com.example.perpustakaan.model.Buku;

import java.util.List;

public interface BukuDao {
    public List<Buku> getAllBuku();
    public Buku getById(long id);
    public void SaveOrUpdate(Buku b);
    public void deleteBuku(long id);
    public void deleteBuku(Buku b);
}
