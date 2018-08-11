package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Peminjaman;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeminjamanRepository extends CrudRepository<Peminjaman,Long> {
}
