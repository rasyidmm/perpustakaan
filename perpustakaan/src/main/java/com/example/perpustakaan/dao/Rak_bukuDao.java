package com.example.perpustakaan.dao;

import com.example.perpustakaan.model.Rak_buku;


import java.util.List;

public interface Rak_bukuDao {
    public List<Rak_buku> getAllRak_buku();
    public Rak_buku getById(long id);
    public void SaveOrUpdate(Rak_buku a);
    public void deleteRak_buku(long id);
    public void deleteRak_buku(Rak_buku a);
}
