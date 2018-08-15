package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Buku;
import com.example.perpustakaan.model.Penerbit;
import com.example.perpustakaan.model.Pengarang;
import com.example.perpustakaan.model.Rak_buku;
import com.example.perpustakaan.service.BukuService;
import com.example.perpustakaan.service.PenerbitService;
import com.example.perpustakaan.service.PengarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class BukuController {
    @Autowired
    BukuService bukuService;


    @RequestMapping("/halamnan")
    public String testtest(){
        return "HalamanAdmin";
    }
    //=============================================pengarangcontrol=========================

    //===========================================penerbitcontrol===========================

    //============================================RakBukucontrol=============================

    //============================================bukucontrol=================================
    @RequestMapping("/buku")
    public ModelAndView HalamanListBuku(){
        return new ModelAndView("HalamanBuku","bukulist",bukuService.getAllBuku());
    }
    @RequestMapping(value = "/tambahbuku")
    public String formbuku(){
        return "bukuview/HalamanFormBuku";
    }
    @RequestMapping(value = "/tambahbuku",method = RequestMethod.POST)
    public String tambahbuku(@ModelAttribute("Buku")Buku buku){

        bukuService.SaveOrUpdate(buku);
        return "redirect:buku";
    }
}
