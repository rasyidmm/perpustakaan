package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Pengarang;
import com.example.perpustakaan.service.BukuService;
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
    @Autowired
    PengarangService pengarangService;
    @RequestMapping("/halamnan")
    public String testtest(){
        return "HalamanAdmin";
    }
    @RequestMapping("/halamanbukulist")
    public ModelAndView HalamanListBuku(){
        return new ModelAndView("bukuview/HalamanBukuList","buku",bukuService.getAllBuku());

    }

    //=============================================pengarangcontrol=========================
    @RequestMapping("/pengarang")
    public ModelAndView masterPengarang(){
        return new ModelAndView("bukuview/HalamanPengarang","listpengara",pengarangService.getAllPengarang());
    }
    @RequestMapping(value = "/tambahpeserta",method = RequestMethod.GET)
    public String formpengarang(){
        return "bukuview/HalamanFormPengarang";
    }
    @RequestMapping(value = "/tambahpeserta",method = RequestMethod.POST)
    public String tambahPengarang(@ModelAttribute("Pengarang")Pengarang pengarang){
        pengarang.setCreateDate(new Date());
        pengarangService.SaveOrUpdate(pengarang);
        return "redirect:pengarang";
    }
    @RequestMapping(value = "/updatepengarang",method = RequestMethod.GET)
    public ModelAndView updatePengarang(@RequestParam("id")long id){
        return new ModelAndView("bukuview/HalamanUpdatePengarang","pengarang",pengarangService.getById(id));
    }
    @RequestMapping(value = "/hapuspengarang")
    public String deletePengarang(@RequestParam("id")long id){
        pengarangService.deletePengarang(id);
        return "redirect:pengarang";
    }
    //===========================================penerbitcontrol===========================
}
