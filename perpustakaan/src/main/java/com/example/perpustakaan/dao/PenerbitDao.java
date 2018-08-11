package com.example.perpustakaan.dao;

import com.example.perpustakaan.model.Penerbit;

import java.util.List;

public interface PenerbitDao {
    public List<Penerbit> getAllPenerbit();
    public Penerbit getById(long id);
    public void SaveOrUpdate(Penerbit a);
    public void deletePenerbit(long id);
    public void deletePenerbit(Penerbit a);
}
