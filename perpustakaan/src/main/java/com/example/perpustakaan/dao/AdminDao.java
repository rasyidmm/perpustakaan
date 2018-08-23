package com.example.perpustakaan.dao;

import com.example.perpustakaan.model.Admin;

import java.util.List;

public interface AdminDao {
    public List<Admin> getAllAdmin();
    public Admin getById(long id);
    public void SaveOrUpdate(Admin a);
    public void deleteAdmin(long id);
    public void deleteAdmin(Admin a);
}
