package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Buku;
import com.example.perpustakaan.model.Penerbit;
import com.example.perpustakaan.model.Pengarang;
import com.example.perpustakaan.model.Rak_buku;
import com.example.perpustakaan.service.*;
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
    KlasifikasiService klasifikasiService;
    @Autowired
    PenerbitService penerbitService;
    @Autowired
    PengarangService pengarangService;
    @Autowired
    Rak_bukuService rak_bukuService;

    @RequestMapping("/buku")
    public ModelAndView HalamanListBuku(){
        return new ModelAndView("bukuview/HalamanBuku","bukulist",bukuService.getAllBuku());
    }
    @RequestMapping(value = "/tambahbuku")
    public ModelAndView formbuku(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listpenerbit",penerbitService.getAllPenerbit());
        mav.addObject("listpengarang",pengarangService.getAllPengarang());
        mav.addObject("listklasifikasi",klasifikasiService.getAllKlasifikasi());
        mav.addObject("listrakbuku",rak_bukuService.getAllRak_buku());
        mav.setViewName("bukuview/HalamanFormBuku");
        return mav;
    }
    @RequestMapping(value = "/tambahbuku",method = RequestMethod.POST)
    public String tambahbuku(@ModelAttribute("Buku")Buku buku,@RequestParam("nama_rakbuku") long nama_rakbuku,@RequestParam("nama_penerbit")long nama_penerbit,
                             @RequestParam("nama_pengarang")long nama_pengarang,@RequestParam("nama_klasifikasi")long nama_klasifikasi){
        buku.setKlasifikasi(klasifikasiService.getById(nama_klasifikasi));
        buku.setPenerbit(penerbitService.getById(nama_penerbit));
        buku.setPengarang(pengarangService.getById(nama_pengarang));
        buku.setRak_buku(rak_bukuService.getById(nama_rakbuku));
        bukuService.SaveOrUpdate(buku);
        return "redirect:buku";
    }
    @RequestMapping(value = "/updatebuku")
    public ModelAndView updatebuku(@RequestParam("id")long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("bukuni",bukuService.getById(id));
        mav.addObject("listpenerbit",penerbitService.getAllPenerbit());
        mav.addObject("listpengarang",pengarangService.getAllPengarang());
        mav.addObject("listklasifikasi",klasifikasiService.getAllKlasifikasi());
        mav.addObject("listrakbuku",rak_bukuService.getAllRak_buku());
        mav.setViewName("bukuview/HalamanUpdateBuku");
        return mav;
    }
    @RequestMapping(value = "/hapusbuku")
    public String deletePengarang(@RequestParam("id")long id){
        bukuService.deleteBuku(id);
        return "redirect:buku";
    }
}
