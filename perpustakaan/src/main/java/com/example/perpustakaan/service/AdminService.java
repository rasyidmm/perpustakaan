package com.example.perpustakaan.service;

import com.example.perpustakaan.dao.AdminDao;
import com.example.perpustakaan.model.Admin;
import com.example.perpustakaan.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminService implements AdminDao {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> lad = new ArrayList<>();
        adminRepository.findAll().forEach(lad::add);
        return lad;
    }

    @Override
    public Admin getById(long id) {
        Admin ad = adminRepository.findById(id).get();
        return ad;
    }

    @Override
    public void SaveOrUpdate(Admin a) {
        adminRepository.save(a);

    }

    @Override
    public void deleteAdmin(long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void deleteAdmin(Admin a) {
        adminRepository.delete(a);
    }
}
