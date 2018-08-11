package com.example.perpustakaan.service;

import com.example.perpustakaan.dao.PengarangDao;
import com.example.perpustakaan.model.Pengarang;
import com.example.perpustakaan.repository.PengarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PengarangService implements PengarangDao {
    @Autowired
    PengarangRepository pengarangRepository;
    @Override
    public List<Pengarang> getAllPengarang() {
        List<Pengarang> pl = new ArrayList<>();
        pengarangRepository.findAll().forEach(pl::add);
        return pl;
    }

    @Override
    public Pengarang getById(long id) {
        Pengarang p = pengarangRepository.findById(id).get();
        return p;
    }

    @Override
    public void SaveOrUpdate(Pengarang a) {
        pengarangRepository.save(a);
    }

    @Override
    public void deletePengarang(long id) {
        pengarangRepository.deleteById(id);
    }

    @Override
    public void deletePengarang(Pengarang a) {
        pengarangRepository.delete(a);
    }
}
