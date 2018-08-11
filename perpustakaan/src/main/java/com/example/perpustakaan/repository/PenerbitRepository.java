package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Penerbit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenerbitRepository extends CrudRepository<Penerbit,Long> {
}
