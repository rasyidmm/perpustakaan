package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Peminjaman;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeminjamanRepository extends CrudRepository<Peminjaman,Long> {
    @Query("select a from Peminjaman a where a.status='Pinjam'")
    List<Peminjaman>findAllByPinjam();
    @Query("select b from Peminjaman b where b.status='Selesai'")
    List<Peminjaman>findAllBySelesai();
}
