package com.example.perpustakaan.service;

import com.example.perpustakaan.dao.PeminjamanDao;
import com.example.perpustakaan.model.Peminjaman;
import com.example.perpustakaan.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PeminjamanService implements PeminjamanDao {
    @Autowired
    PeminjamanRepository peminjamanRepository;
    @Override
    public List<Peminjaman> getAllPeminjaman() {
       List<Peminjaman> pl = new ArrayList<>();
       peminjamanRepository.findAll().forEach(pl::add);
       return pl;
    }

    @Override
    public Peminjaman getById(long id) {
        Peminjaman p = peminjamanRepository.findById(id).get();
        return p;
    }

    @Override
    public void SaveOrUpdate(Peminjaman a) {
        peminjamanRepository.save(a);
    }

    @Override
    public void deletePeminjaman(long id) {
        peminjamanRepository.deleteById(id);
    }

    @Override
    public void deletePeminjaman(Peminjaman a) {
        peminjamanRepository.delete(a);
    }

    public List<Peminjaman>findAllByPinjam(){
        return peminjamanRepository.findAllByPinjam();
    }
    public List<Peminjaman>findAllBySelesai(){
        return peminjamanRepository.findAllBySelesai();
    }
    public List<Peminjaman>findPeminjamenByAnggotaid(long id){
        return peminjamanRepository.findPeminjamenByAnggotaid(id);
    }
}
