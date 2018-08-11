package com.example.perpustakaan.service;

import com.example.perpustakaan.dao.KlasifikasiDao;
import com.example.perpustakaan.model.Klasifikasi;
import com.example.perpustakaan.repository.KlasifikasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KlasifikasiService implements KlasifikasiDao {
    @Autowired
    KlasifikasiRepository klasifikasiRepository;
    @Override
    public List<Klasifikasi> getAllKlasifikasi() {
       List<Klasifikasi> kl = new ArrayList<>();
       klasifikasiRepository.findAll().forEach(kl::add);
       return kl;
    }

    @Override
    public Klasifikasi getById(long id) {
        Klasifikasi k = klasifikasiRepository.findById(id).get();
        return k;
    }

    @Override
    public void SaveOrUpdate(Klasifikasi a) {
        klasifikasiRepository.save(a);
    }

    @Override
    public void deleteKlasifikasi(long id) {
        klasifikasiRepository.deleteById(id);
    }

    @Override
    public void deleteKlasifikasi(Klasifikasi a) {
        klasifikasiRepository.delete(a);
    }
}
