package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Klasifikasi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlasifikasiRepository extends CrudRepository<Klasifikasi,Long> {
}
