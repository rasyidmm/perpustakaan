package com.example.perpustakaan.service;

import com.example.perpustakaan.dao.PeminjamanDao;
import com.example.perpustakaan.dao.PenerbitDao;
import com.example.perpustakaan.model.Peminjaman;
import com.example.perpustakaan.model.Penerbit;
import com.example.perpustakaan.repository.PenerbitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PenerbitService implements PenerbitDao {
    @Autowired
    PenerbitRepository penerbitRepository;
    @Override
    public List<Penerbit> getAllPenerbit() {
        List<Penerbit> pl = new ArrayList<>();
        penerbitRepository.findAll().forEach(pl::add);
        return pl;
    }

    @Override
    public Penerbit getById(long id) {
        Penerbit p = penerbitRepository.findById(id).get();
        return p;
    }

    @Override
    public void SaveOrUpdate(Penerbit a) {
        penerbitRepository.save(a);
    }

    @Override
    public void deletePenerbit(long id) {
        penerbitRepository.deleteById(id);
    }

    @Override
    public void deletePenerbit(Penerbit a) {
        penerbitRepository.delete(a);
    }
}
