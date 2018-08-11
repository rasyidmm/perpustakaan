package com.example.perpustakaan.dao;

import com.example.perpustakaan.model.Petugas;

import java.util.List;

public interface PetugasDao {
    public List<Petugas> getAllPetugas();
    public Petugas getById(long id);
    public void SaveOrUpdate(Petugas a);
    public void deletePetugas(long id);
    public void deletePetugas(Petugas a);
}
