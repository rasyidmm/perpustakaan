package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Anggota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnggotaRepository extends CrudRepository<Anggota,Long> {
}