package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Anggota;
import com.example.perpustakaan.model.Peminjaman;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnggotaRepository extends CrudRepository<Anggota,Long> {
}
