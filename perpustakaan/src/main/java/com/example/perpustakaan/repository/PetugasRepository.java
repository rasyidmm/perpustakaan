package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Petugas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetugasRepository extends CrudRepository<Petugas,Long> {
}
