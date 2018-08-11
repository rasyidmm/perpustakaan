package com.example.perpustakaan.dao;

import com.example.perpustakaan.model.Pengarang;

import java.util.List;

public interface PengarangDao {
    public List<Pengarang> getAllPengarang();
    public Pengarang getById(long id);
    public void SaveOrUpdate(Pengarang a);
    public void deletePengarang(long id);
    public void deletePengarang(Pengarang a);
}
