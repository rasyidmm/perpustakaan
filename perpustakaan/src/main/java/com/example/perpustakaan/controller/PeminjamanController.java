package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Buku;
import com.example.perpustakaan.model.Peminjaman;
import com.example.perpustakaan.service.AnggotaService;
import com.example.perpustakaan.service.BukuService;
import com.example.perpustakaan.service.PeminjamanService;
import com.example.perpustakaan.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.DateTimeException;
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
    @RequestMapping(value = "/peminjaman",method = RequestMethod.GET)
    public ModelAndView MasterPeminjaman(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listpinjam",peminjamanService.findAllByPinjam());
        mav.addObject("listselesai",peminjamanService.findAllBySelesai());
        mav.setViewName("peminjamanview/HalamanPeminjaman");
        return mav;
//        return new ModelAndView("peminjamanview/HalamanPeminjaman","listpeminjaaman",peminjamanService.getAllPeminjaman());
    }
    @RequestMapping(value = "/tambahpeminjaman",method = RequestMethod.GET)
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
        peminjaman.setStatus("Pinjam");
        peminjaman.setTanggal_pinjam(new Date());
        Buku buku = bukuService.getById(judul_buku);
        Long jumlah = buku.getJumlah_buku()-1;
        buku.setJumlah_buku(jumlah);
        bukuService.SaveOrUpdate(buku);
        peminjamanService.SaveOrUpdate(peminjaman);
        return "redirect:peminjaman";
    }
    @RequestMapping(value = "/pengembalianbuk")
    public String pengembalianbuku(@RequestParam("id")long id){
        Double denda = Double.valueOf(3000);
        Peminjaman peminjaman = peminjamanService.getById(id);
        long tangalkembali =peminjaman.getTanggal_kembali().getTime();;
        long tangalhariini = new Date().getTime();
        long Telat = (tangalhariini - tangalkembali)/(24 * 60 * 60 * 1000);
        Double tataldenda = Telat*denda;

        Buku buku = bukuService.getById(peminjaman.getBuku().getId());
        long jumlahbuku = buku.getJumlah_buku()+1;
        buku.setJumlah_buku(jumlahbuku);
        peminjaman.setDenda(Double.valueOf(tataldenda));
        peminjaman.setStatus("Selesai");
        peminjamanService.SaveOrUpdate(peminjaman);
        bukuService.SaveOrUpdate(buku);
        return "redirect:peminjaman";
    }
    @RequestMapping(value = "/viewpeminjaman")
    public ModelAndView viewPeminjaman(@RequestParam("id")long id){
        return new ModelAndView("peminjamanview/HalamanPeminjamanView","peminjaman",peminjamanService.getById(id));
    }
//    @RequestMapping(value = "/updatepeminjaman",method = RequestMethod.GET)
//    public ModelAndView updatePeminjaman(@RequestParam("id") long id){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("peminjaman",peminjamanService.getById(id));
//        mav.addObject("listbuku",bukuService.getAllBuku());
//        mav.addObject("listanggota",anggotaService.getAllAnggota());
//        mav.addObject("listpetugas",petugasService.getAllPetugas());
//        mav.setViewName("peminjamanview/HalamanPeminjamanUpdate");
//        return mav;
//    }
//    @RequestMapping(value = "/updatepeminjaman",method = RequestMethod.POST)
//    public String updatePeminjaman(@ModelAttribute("Peminjaman")Peminjaman peminjaman, @RequestParam("nama_anggota")long namasanggota,
//                                   @RequestParam("judul_buku")long judul_buku,@RequestParam("nama_petugas")long nama_petugas){
//        peminjaman.setAnggota(anggotaService.getById(namasanggota));
//        peminjaman.setBuku(bukuService.getById(judul_buku));
//        peminjaman.setPetugas(petugasService.getById(nama_petugas));
//        peminjaman.setTanggal_pinjam(new Date());
//        peminjamanService.SaveOrUpdate(peminjaman);
//        return "redirect:peminjaman";
//    }
    @RequestMapping(value = "hapuspeminjaman")
    public String deletePinjam(@RequestParam("id")long id){
        peminjamanService.deletePeminjaman(id);
        return "redirect:peminjaman";
    }
}
