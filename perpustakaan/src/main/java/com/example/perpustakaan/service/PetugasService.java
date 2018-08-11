package com.example.perpustakaan.service;

import com.example.perpustakaan.dao.PetugasDao;
import com.example.perpustakaan.model.Petugas;
import com.example.perpustakaan.repository.PetugasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PetugasService implements PetugasDao {
    @Autowired
    PetugasRepository petugasRepository;
    @Override
    public List<Petugas> getAllPetugas() {
        List<Petugas> pl = new ArrayList<>();
        petugasRepository.findAll().forEach(pl::add);
        return pl;
    }

    @Override
    public Petugas getById(long id) {
        Petugas p = petugasRepository.findById(id).get();
        return p;
    }

    @Override
    public void SaveOrUpdate(Petugas a) {
        petugasRepository.save(a);
    }

    @Override
    public void deletePetugas(long id) {
        petugasRepository.deleteById(id);
    }

    @Override
    public void deletePetugas(Petugas a) {
        petugasRepository.delete(a);
    }
}
