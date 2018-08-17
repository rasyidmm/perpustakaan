package com.example.perpustakaan.controller;

import com.example.perpustakaan.model.Buku;
import com.example.perpustakaan.model.Penerbit;
import com.example.perpustakaan.model.Pengarang;
import com.example.perpustakaan.model.Rak_buku;
import com.example.perpustakaan.service.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BukuController {
    String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
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
    @RequestMapping("/bukuview")
    public ModelAndView Halamanview(@RequestParam("id")long id){
        return new ModelAndView("bukuview/HalamanViewBuku","bukudetail",bukuService.getById(id));
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
    public final String SaveDirectory= "E:/projekmu/perpustakaangit/perpustakaan/target/classes/static/image/coverbuku/";
    @RequestMapping(value = "/tambahbuku",method = RequestMethod.POST)
    public String tambahbuku(@ModelAttribute("Buku")Buku buku, @RequestParam("nama_rakbuku") long nama_rakbuku, @RequestParam("nama_penerbit")long nama_penerbit,
                             @RequestParam("nama_pengarang")long nama_pengarang, @RequestParam("nama_klasifikasi")long nama_klasifikasi,
                             @RequestParam("coverbuku")MultipartFile coverbuku,RedirectAttributes redirectAttributes){
        try {
            byte[] bytes = coverbuku.getBytes();
            String match= String.valueOf(Math.random());
            String random =  match.replace(".","");
            String nama= coverbuku.getOriginalFilename().replace(coverbuku.getOriginalFilename(), FilenameUtils.getBaseName(coverbuku.getOriginalFilename()).concat(currentDate+random) + "." + FilenameUtils.getExtension(coverbuku.getOriginalFilename())).toLowerCase();
            buku.setGambar_buku(nama);
            Path path = Paths.get(SaveDirectory +nama);
            Files.write(path, bytes);
            buku.setKlasifikasi(klasifikasiService.getById(nama_klasifikasi));
            buku.setPenerbit(penerbitService.getById(nama_penerbit));
            buku.setPengarang(pengarangService.getById(nama_pengarang));
            buku.setRak_buku(rak_bukuService.getById(nama_rakbuku));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    @RequestMapping(value = "/updatebuku",method = RequestMethod.POST)
    public String updatebuku(@ModelAttribute("Buku")Buku buku, @RequestParam("nama_rakbuku") long nama_rakbuku, @RequestParam("nama_penerbit")long nama_penerbit,
                             @RequestParam("nama_pengarang")long nama_pengarang, @RequestParam("nama_klasifikasi")long nama_klasifikasi,
                             @RequestParam("coverbuku")MultipartFile coverbuku,@RequestParam("id")long id,RedirectAttributes redirectAttributes){

        Buku bu = bukuService.getById(id);
        String exten= FilenameUtils.getExtension(bu.getGambar_buku().toLowerCase());
        String filecover = bu.getGambar_buku();
        if (coverbuku.isEmpty()==true){
            buku.setGambar_buku(filecover);
        }else {
            String covernya = bu.getGambar_buku();
            File file = new File(SaveDirectory.concat(covernya));
            file.delete();
            try {
                byte[] bytes = coverbuku.getBytes();
                String match= String.valueOf(Math.random());
                String random =  match.replace(".","");
                String nama= coverbuku.getOriginalFilename().replace(coverbuku.getOriginalFilename(), FilenameUtils.getBaseName(coverbuku.getOriginalFilename()).concat(currentDate+random) + "." + FilenameUtils.getExtension(coverbuku.getOriginalFilename())).toLowerCase();
                buku.setGambar_buku(nama);
                Path path = Paths.get(SaveDirectory +nama);
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        buku.setKlasifikasi(klasifikasiService.getById(nama_klasifikasi));
        buku.setPenerbit(penerbitService.getById(nama_penerbit));
        buku.setPengarang(pengarangService.getById(nama_pengarang));
        buku.setRak_buku(rak_bukuService.getById(nama_rakbuku));
        bukuService.SaveOrUpdate(buku);
        return "redirect:buku";
    }

    @RequestMapping(value = "/hapusbuku")
    public String deletePengarang(@RequestParam("id")long id){
        Buku buku = bukuService.getById(id);
        String covernya = buku.getGambar_buku();
        File file = new File(SaveDirectory.concat(covernya));
        System.out.println(file);
        file.delete();
        bukuService.deleteBuku(id);
        return "redirect:buku";
    }
}
