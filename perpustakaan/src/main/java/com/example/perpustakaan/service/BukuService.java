package com.example.perpustakaan.service;

import com.example.perpustakaan.dao.BukuDao;
import com.example.perpustakaan.model.Buku;
import com.example.perpustakaan.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BukuService implements BukuDao {
    @Autowired
    BukuRepository bukuRepository;
    @Override
    public List<Buku> getAllBuku() {
        List<Buku> lb = new ArrayList<>();
        bukuRepository.findAll().forEach(lb::add);
        return lb;
    }

    @Override
    public Buku getById(long id) {
        Buku buku = bukuRepository.findById(id).get();
        return buku;
    }

    @Override
    public void SaveOrUpdate(Buku a) {
        bukuRepository.save(a);
    }

    @Override
    public void deleteBuku(long id) {
        bukuRepository.deleteById(id);
    }

    @Override
    public void deleteBuku(Buku a) {
        bukuRepository.delete(a);
    }
}
