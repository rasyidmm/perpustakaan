package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Peminjaman;
import com.example.perpustakaan.service.AnggotaService;
import com.example.perpustakaan.service.BukuService;
import com.example.perpustakaan.service.PeminjamanService;
import com.example.perpustakaan.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class PeminjamanController {
    @Autowired
    PeminjamanService peminjamanService;
    @Autowired
    BukuService bukuService;
    @Autowired
    AnggotaService anggotaService;
    @Autowired
    PetugasService petugasService;
    @RequestMapping(value = "peminjaman",method = RequestMethod.GET)
    public ModelAndView MasterPeminjaman(){
        return new ModelAndView("peminjamanview/HalamanPeminjaman","listpeminjaaman",peminjamanService.getAllPeminjaman());
    }
    @RequestMapping(value = "tambahpeminjaman",method = RequestMethod.GET)
    public ModelAndView formPeminjaman(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listbuku",bukuService.getAllBuku());
        mav.addObject("listanggota",anggotaService.getAllAnggota());
        mav.addObject("listpetugas",petugasService.getAllPetugas());
        mav.setViewName("peminjamanview/HalamanPeminjamanForm");
        return mav;
    }
    @RequestMapping(value = "/tambahpeminjaman",method = RequestMethod.POST)
    public String tambahPeminjaman(@ModelAttribute("Peminjaman")Peminjaman peminjaman, @RequestParam("nama_anggota")long namasanggota,
                                   @RequestParam("judul_buku")long judul_buku,@RequestParam("nama_petugas")long nama_petugas){
        peminjaman.setAnggota(anggotaService.getById(namasanggota));
        peminjaman.setBuku(bukuService.getById(judul_buku));
        peminjaman.setPetugas(petugasService.getById(nama_petugas));
        peminjaman.setTanggal_pinjam(new Date());
        peminjamanService.SaveOrUpdate(peminjaman);
        return "redirect:peminjaman";
    }
    @RequestMapping(value = "/pengembalianbuk")
    public String pengembalianbuku(@RequestParam("id")long id){
        long denda = 3000;
        Peminjaman peminjaman = peminjamanService.getById(id);
        Date tangalkembali =peminjaman.getTanggal_kembali();
        Date tangalhariini = new Date();
        long Telat = Math.abs(tangalhariini.getTime()-tangalkembali.getTime());
        long tataldenda = Telat*denda;
        peminjaman.setDenda(tataldenda);
        peminjamanService.SaveOrUpdate(peminjaman);
        return "redirect:peminjaman";
    }
}
