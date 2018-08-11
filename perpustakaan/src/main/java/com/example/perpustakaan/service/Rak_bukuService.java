package com.example.perpustakaan.service;

import com.example.perpustakaan.dao.Rak_bukuDao;
import com.example.perpustakaan.model.Rak_buku;
import com.example.perpustakaan.repository.Rak_bukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Rak_bukuService implements Rak_bukuDao {
    @Autowired
    Rak_bukuRepository rak_bukuRepository;
    @Override
    public List<Rak_buku> getAllRak_buku() {
       List<Rak_buku> rl = new ArrayList<>();
       rak_bukuRepository.findAll().forEach(rl::add);
       return rl;
    }

    @Override
    public Rak_buku getById(long id) {
        Rak_buku r =rak_bukuRepository.findById(id).get();
        return  r;
    }

    @Override
    public void SaveOrUpdate(Rak_buku a) {
        rak_bukuRepository.save(a);
    }

    @Override
    public void deleteRak_buku(long id) {
        rak_bukuRepository.deleteById(id);
    }

    @Override
    public void deleteRak_buku(Rak_buku a) {
        rak_bukuRepository.delete(a);
    }
}
