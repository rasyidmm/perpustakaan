package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Rak_buku;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rak_bukuRepository extends CrudRepository<Rak_buku,Long> {
}
