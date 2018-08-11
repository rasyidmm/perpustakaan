package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Pengarang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PengarangRepository extends CrudRepository<Pengarang,Long> {
}
