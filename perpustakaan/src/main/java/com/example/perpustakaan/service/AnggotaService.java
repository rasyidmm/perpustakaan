package com.example.perpustakaan.service;

import com.example.perpustakaan.dao.AnggotaDao;
import com.example.perpustakaan.model.Anggota;
import com.example.perpustakaan.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AnggotaService implements AnggotaDao {
    @Autowired
    AnggotaRepository anggotaRepository;
    @Override
    public List<Anggota> getAllAnggota() {
       List<Anggota> la = new ArrayList<>();
       anggotaRepository.findAll().forEach(la::add);
       return la;
    }

    @Override
    public Anggota getById(long id) {
        Anggota a = anggotaRepository.findById(id).get();
        return a;
    }

    @Override
    public void SaveOrUpdate(Anggota a) {
        anggotaRepository.save(a);
    }

    @Override
    public void deleteAnggota(long id) {
        anggotaRepository.deleteById(id);
    }

    @Override
    public void deleteAnggota(Anggota a) {
        anggotaRepository.delete(a);
    }
}
