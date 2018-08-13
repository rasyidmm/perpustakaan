package com.example.perpustakaan.controller;

import com.example.perpustakaan.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BukuController {
    @Autowired
    BukuService bukuService;
    @RequestMapping("/halamnan")
    public String testtest(){
        return "HalamanAdmin";
    }
    @RequestMapping("/halamanbukulist")
    public ModelAndView HalamanListBuku(){
        return new ModelAndView("buku/HalamanBukuList","buku",bukuService.getAllBuku());

    }
}
