package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Buku;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepository extends CrudRepository<Buku,Long> {
}
